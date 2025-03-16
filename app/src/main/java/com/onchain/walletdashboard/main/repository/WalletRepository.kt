package com.onchain.walletdashboard.main.repository

import com.onchain.walletdashboard.App
import com.onchain.walletdashboard.common.JsonUtils
import com.onchain.walletdashboard.main.bean.CurrencyResponse
import com.onchain.walletdashboard.main.bean.LiveRatesResponse
import com.onchain.walletdashboard.main.bean.WalletBalanceResponse
import com.onchain.walletdashboard.mvvm.BaseRepository


class WalletRepository : BaseRepository() {


    fun getCurrencyResponse(): CurrencyResponse {
        val jsonString = readJsonFromAssets("currencies-json")
        return JsonUtils.fromJson(jsonString,CurrencyResponse::class.java)
    }
    fun getLiveRatesResponse(): LiveRatesResponse {
        val jsonString = readJsonFromAssets("live-rates-json")
        return JsonUtils.fromJson(jsonString,LiveRatesResponse::class.java)
    }
    fun getWalletBalanceResponse(): WalletBalanceResponse {
        val jsonString = readJsonFromAssets("wallet-balance-json")
        return JsonUtils.fromJson(jsonString,WalletBalanceResponse::class.java)
    }

    /**
     * 从 assets 目录读取指定文件名的 JSON 字符串
     *
     * @param fileName 文件名
     * @return JSON 字符串
     * @throws IOException 如果读取文件时发生错误
     */
    private fun readJsonFromAssets(fileName: String): String {
        return App.instance.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}
