package com.sunnat629.clientside.util

import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE



object PrefUtils {
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE)
    }

     fun storeUsername(context: Context, username: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString("username", username)
        editor.apply()
    }

     fun getUsername(context: Context): String? {
        return getSharedPreferences(context).getString("username", null)
    }

     fun storeUsernameID(context: Context, id: Long) {
        val editor = getSharedPreferences(context).edit()
        editor.putLong("id", id)
        editor.apply()
    }

     fun getUsernameID(context: Context): Long? {
        return getSharedPreferences(context).getLong("id", -1)
    }

     fun storePassword(context: Context, password: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString("password", password)
        editor.apply()
    }

     fun getPassword(context: Context): String? {
        return getSharedPreferences(context).getString("password", null)
    }
}