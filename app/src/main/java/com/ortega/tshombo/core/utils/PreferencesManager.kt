package com.ortega.tshombo.core.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesManager @Inject constructor(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun clearData() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}