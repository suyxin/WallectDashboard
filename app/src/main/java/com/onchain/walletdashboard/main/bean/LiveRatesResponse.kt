package com.onchain.walletdashboard.main.bean



import com.google.gson.annotations.SerializedName

// 根对象数据类
data class LiveRatesResponse(
    @SerializedName("ok")
    val ok: Boolean,
    @SerializedName("warning")
    val warning: String,
    @SerializedName("tiers")
    val tiers: List<Tier>
)

// 汇率层级对象数据类
data class Tier(
    @SerializedName("from_currency")
    val fromCurrency: String,
    @SerializedName("to_currency")
    val toCurrency: String,
    @SerializedName("rates")
    val rates: List<Rate>,
    @SerializedName("time_stamp")
    val timeStamp: Long
)

// 汇率对象数据类
data class Rate(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("rate")
    val rate: Double
)
