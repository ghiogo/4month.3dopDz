package com.example.a4month3dopdz

import android.app.Application
import com.example.a4month3dopdz.utils.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initPref()
    }

    private fun initPref() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
    }
}
