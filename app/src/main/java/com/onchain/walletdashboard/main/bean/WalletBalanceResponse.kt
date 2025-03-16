package com.onchain.walletdashboard.main.bean



import com.google.gson.annotations.SerializedName

// 根对象数据类
data class WalletBalanceResponse(
    @SerializedName("ok")
    val ok: Boolean,
    @SerializedName("warning")
    val warning: String,
    @SerializedName("wallet")
    val wallet: List<WalletItem>
)

// 钱包项数据类
data class WalletItem(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("amount")
    val amount: Double
)
