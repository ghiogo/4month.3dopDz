package com.example.a4month3dopdz.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("key", Context.MODE_PRIVATE)
    }

    var saveText: String?
        set(value) = sharedPreferences.edit().putString("key", value.toString()).apply()
        get() = sharedPreferences.getString("key", " ")

    var savePass: String?
        set(value) = sharedPreferences.edit().putString("key2", value.toString()).apply()
        get() = sharedPreferences.getString("key2", " ")
}