package com.onchain.walletdashboard.main.bean

data class WalletItemWrapper(
    val icon: String,
    val name: String,
    val currency: String,
    val amount: Double,
    val usdAmount: Double,

)
