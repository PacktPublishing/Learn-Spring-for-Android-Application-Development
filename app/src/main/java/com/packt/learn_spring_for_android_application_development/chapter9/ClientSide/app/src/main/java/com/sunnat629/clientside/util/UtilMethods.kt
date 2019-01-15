package com.sunnat629.clientside.util

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.sunnat629.clientside.R
import android.support.v4.content.ContextCompat.getSystemService


object UtilMethods {

    private lateinit var progressDialogBuilder: AlertDialog.Builder
    private lateinit var progressDialog: AlertDialog

    private val TAG: String = "---UtilMethods"

    /**
     * @param context
     * @action show progress loader
     */
    fun showLoading(context: Context){
        progressDialogBuilder = AlertDialog.Builder(context)
        progressDialogBuilder.setCancelable(false) // if you want user to wait for some process to finish,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progressDialogBuilder.setView(R.layout.layout_loading_dialog)
        }

        progressDialog = progressDialogBuilder.create()
        progressDialog.show()
    }

    /**
     * @action hide progress loader
     */
    fun hideLoading(){
        try {
            progressDialog.dismiss()
        }catch (ex: java.lang.Exception){
            Log.e(TAG, ex.toString())
        }

    }


    /**
     * @param context
     * @action show Long toast message
     */
    fun showLongToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


    /**
     * @param context
     * @return true or false mentioning the device is connected or not
     * @brief checking the internet connection on run time
     */
    fun isConnectedToInternet(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val allNetworks = manager?.allNetworks?.let { it } ?: return false
            allNetworks.forEach { network ->
                val info = manager.getNetworkInfo(network)
                if (info.state == NetworkInfo.State.CONNECTED) return true
            }
        } else {
            val allNetworkInfo = manager?.allNetworkInfo?.let { it } ?: return false
            allNetworkInfo.forEach { info ->
                if (info.state == NetworkInfo.State.CONNECTED) return true
            }
        }
        return false
    }

}