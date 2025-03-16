package com.onchain.walletdashboard.main.activity

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onchain.walletdashboard.R
import com.onchain.walletdashboard.databinding.ActivityMainBinding
import com.onchain.walletdashboard.main.adapter.WalletAdapter
import com.onchain.walletdashboard.main.bean.WalletItemWrapper

import com.onchain.walletdashboard.main.viewmodel.WalletViewModel
import com.onchain.walletdashboard.mvvm.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var walletViewModel: WalletViewModel
    private lateinit var  mRecyclerView: RecyclerView
    private lateinit var mAdapter: WalletAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        walletViewModel = createViewModel(WalletViewModel::class.java)
        mRecyclerView = mBinding.recyclerView
        mAdapter = WalletAdapter()
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        initData()
    }

    private fun initData() {

        // 观察 Currency list LiveData
        // 观察 walletItemWrappersLiveData
        walletViewModel.walletItemWrappersLiveData.observe(this, Observer { walletItemWrappers ->
            // 处理 walletItemWrappers 数据
            handleWalletItemWrappers(walletItemWrappers)
        })
        // 观察 walletSumUsdValueLiveData
        walletViewModel.walletSumUsdValueLiveData.observe(this, Observer { walletSumUsdValue ->
            // 处理 walletSumUsdValue 数据
            handleWalletSumUsdValue(walletSumUsdValue)
        })
        walletViewModel.fetchData()

    }

    private fun handleWalletSumUsdValue(walletSumUsdValue: Double?) {
        walletSumUsdValue?.let {
            mBinding.tvWalletSumUsdValue.text = formatAmount(it)
        }

    }

    private fun formatAmount(amount: Double): SpannableString {
        val text = "\$ ${String.format("%.2f", amount)} USD"

        val spannableString = SpannableString(text)

        // 设置 $ 符号的样式
        spannableString.setSpan(
            ForegroundColorSpan(Color.GRAY),
            0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            RelativeSizeSpan(0.85f),
            0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // 设置 USD 的样式
        spannableString.setSpan(
            ForegroundColorSpan(Color.GRAY),
            text.length - 3, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            RelativeSizeSpan(0.85f),
            text.length - 3, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // 设置数字的样式
        spannableString.setSpan(
            ForegroundColorSpan(Color.WHITE),
            1, text.length - 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return spannableString
    }
    private fun handleWalletItemWrappers(walletItemWrappers: List<WalletItemWrapper>?) {
       walletItemWrappers?.forEach{
           println(it)
       }
        walletItemWrappers?.let {
            mAdapter.setList(it)
        }
    }

}
