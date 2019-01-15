package com.sunnat629.clientside.util

import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE



class PrefUtils {
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE)
    }

    fun storeUername(context: Context, username: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString("username", username)
        editor.commit()
    }

    fun getUername(context: Context): String? {
        return getSharedPreferences(context).getString("username", null)
    }

    fun storePassword(context: Context, password: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString("password", password)
        editor.commit()
    }

    fun getPassword(context: Context): String? {
        return getSharedPreferences(context).getString("password", null)
    }
}