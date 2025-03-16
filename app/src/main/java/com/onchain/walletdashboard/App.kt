package com.onchain.walletdashboard

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class App : Application() {

    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        initGlide()
    }


    private fun initGlide() {
       Glide.with(this)
            .setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.ic_launcher_foreground))
    }


    override fun onTerminate() {
        super.onTerminate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }


}