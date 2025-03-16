package com.onchain.walletdashboard.mvvm


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
abstract  class BaseActivity : AppCompatActivity() {
    /**
     * 创建 ViewModel
     *
     * @param cls ViewModel 类型
     * @return T ViewModel 实例
     */

    fun <T : ViewModel> createViewModel(cls: Class<T>): T {
        return ViewModelProvider(this).get(cls)
    }
}