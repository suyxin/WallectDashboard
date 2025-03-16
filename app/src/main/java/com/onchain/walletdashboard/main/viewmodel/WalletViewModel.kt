package com.onchain.walletdashboard.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onchain.walletdashboard.main.bean.Currency
import com.onchain.walletdashboard.main.bean.Tier
import com.onchain.walletdashboard.main.bean.WalletItem
import com.onchain.walletdashboard.main.bean.WalletItemWrapper
import com.onchain.walletdashboard.main.repository.WalletRepository
import com.onchain.walletdashboard.mvvm.BaseViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WalletViewModel : BaseViewModel() {

    private val walletRepository by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { WalletRepository() }

    // LiveData to hold WalletItemWrapper list
    private val _walletItemWrappersLiveData = MutableLiveData<List<WalletItemWrapper>>()
    val walletItemWrappersLiveData: LiveData<List<WalletItemWrapper>> get() = _walletItemWrappersLiveData
    // LiveData to hold the sum of USD values
    private val _walletSumUsdValueLiveData = MutableLiveData<Double>()
    val walletSumUsdValueLiveData: LiveData<Double> get() = _walletSumUsdValueLiveData

    // Function to fetch Currency list
    suspend fun fetchCurrencyList(): List<Currency> {
        return withContext(Dispatchers.IO) {
            walletRepository.getCurrencyResponse().currencies
        }
    }

    // Function to fetch Tier list
    suspend fun fetchTierList(): List<Tier> {
        return withContext(Dispatchers.IO) {
            walletRepository.getLiveRatesResponse().tiers
        }
    }

    // Function to fetch WalletItem list
    suspend fun fetchWalletItemList(): List<WalletItem> {
        return withContext(Dispatchers.IO) {
            walletRepository.getWalletBalanceResponse().wallet
        }
    }

    // Function to fetch all data concurrently and update LiveData
    fun fetchData() {
        viewModelScope.launch {
            try {
                val deferredCurrencyList: Deferred<List<Currency>> = async { fetchCurrencyList() }
                val deferredTierList: Deferred<List<Tier>> = async { fetchTierList() }
                val deferredWalletItemList: Deferred<List<WalletItem>> = async { fetchWalletItemList() }

                val currencyList = deferredCurrencyList.await()
                val tierList = deferredTierList.await()
                val walletItemList = deferredWalletItemList.await()

                // 创建一个映射来快速查找 Currency 和 Tier
                val currencyMap = currencyList.associateBy { it.code }
                val tierMap = tierList.associateBy { it.fromCurrency }

                // 处理 walletItemList 并构建 WalletItemWrapper 列表
                var walletSumUsdValue = 0.00
                val walletItemWrappers = walletItemList.mapNotNull { walletItem ->
                    val currency = currencyMap[walletItem.currency]
                    val tier = tierMap[walletItem.currency]?.rates?.firstOrNull()

                    if (currency != null && tier != null) {
                        val usdAmount = walletItem.amount * tier.rate
                        walletSumUsdValue += usdAmount
                        WalletItemWrapper(
                            currency = walletItem.currency,
                            amount = walletItem.amount,
                            usdAmount = usdAmount,
                            icon = currency.colorfulImageUrl,
                            name = currency.name
                        )
                    } else {
                        null // 如果找不到对应的 Currency 或 Tier，则跳过
                    }
                }
                // 更新 LiveData
                _walletItemWrappersLiveData.postValue(walletItemWrappers)
                _walletSumUsdValueLiveData.postValue(walletSumUsdValue)
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the exception as needed
            }
        }
    }


}
