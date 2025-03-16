package com.onchain.walletdashboard.mvvm

open class BaseViewModel : AutoDisposeViewModel(){
    fun onDestroy() {
        super.onCleared()
    }
}
