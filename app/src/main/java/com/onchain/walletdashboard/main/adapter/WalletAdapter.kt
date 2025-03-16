package com.onchain.walletdashboard.main.adapter


import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.onchain.walletdashboard.R
import com.onchain.walletdashboard.databinding.ItemWalletBinding
import com.onchain.walletdashboard.main.bean.WalletItemWrapper
import java.text.DecimalFormat

class WalletAdapter :
    BaseQuickAdapter<WalletItemWrapper, BaseDataBindingHolder<ItemWalletBinding>>(R.layout.item_wallet) {
    private val usdFormat = DecimalFormat("#,##0.00")
    private val amountFormat = DecimalFormat("#,##0.00000000")
    override fun convert(holder: BaseDataBindingHolder<ItemWalletBinding>, item: WalletItemWrapper) {
        val binding = holder.dataBinding
        binding?.apply {
            usdTextView.text = "$ ${usdFormat.format(item.usdAmount)}"
            currencyTextView.text = "${item.amount} ${item.currency}"
            nameTextView.text = "${item.name}"
            Glide.with(iconImageView).load(item.icon).into(iconImageView)
        }
    }
}
