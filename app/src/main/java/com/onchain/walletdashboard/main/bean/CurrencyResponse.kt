package com.onchain.walletdashboard.main.bean



import com.google.gson.annotations.SerializedName

// 根对象数据类
data class CurrencyResponse(
    @SerializedName("currencies")
    val currencies: List<Currency>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("ok")
    val ok: Boolean
)

// 货币对象数据类
data class Currency(
    @SerializedName("coin_id")
    val coinId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("token_decimal")
    val tokenDecimal: Int,
    @SerializedName("contract_address")
    val contractAddress: String,
    @SerializedName("withdrawal_eta")
    val withdrawalEta: List<String>,
    @SerializedName("colorful_image_url")
    val colorfulImageUrl: String,
    @SerializedName("gray_image_url")
    val grayImageUrl: String,
    @SerializedName("has_deposit_address_tag")
    val hasDepositAddressTag: Boolean,
    @SerializedName("min_balance")
    val minBalance: Double,
    @SerializedName("blockchain_symbol")
    val blockchainSymbol: String,
    @SerializedName("trading_symbol")
    val tradingSymbol: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("explorer")
    val explorer: String,
    @SerializedName("is_erc20")
    val isErc20: Boolean,
    @SerializedName("gas_limit")
    val gasLimit: Int,
    @SerializedName("token_decimal_value")
    val tokenDecimalValue: String,
    @SerializedName("display_decimal")
    val displayDecimal: Int,
    @SerializedName("supports_legacy_address")
    val supportsLegacyAddress: Boolean,
    @SerializedName("deposit_address_tag_name")
    val depositAddressTagName: String,
    @SerializedName("deposit_address_tag_type")
    val depositAddressTagType: String,
    @SerializedName("num_confirmation_required")
    val numConfirmationRequired: Int
)
