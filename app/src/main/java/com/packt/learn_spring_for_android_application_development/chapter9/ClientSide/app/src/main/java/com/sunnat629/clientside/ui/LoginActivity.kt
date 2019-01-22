package com.sunnat629.clientside.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.sunnat629.clientside.R
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.util.PrefUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       setUsernamePassword()
        login_submit.setOnClickListener {
            logInUser(false)
        }
        need_reg.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

            startActivity(intent)
        }

    }

    private fun setUsernamePassword() {
        if (PrefUtils.getUsername(this) != null
            || PrefUtils.getPassword(this) != null) {
            username_input_login.setText(PrefUtils.getUsername(this))
            password_input_login.setText(PrefUtils.getPassword(this))
        }
    }

    @SuppressLint("CheckResult")
    private fun logInUser(auto: Boolean){

        APIClient.profileAPICall(username_input_login.text.toString(), password_input_login.text.toString())
            .loginProfile(username_input_login.text.toString(),password_input_login.text.toString() )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    newUser ->

                Log.wtf("********", newUser.toString())
                if(newUser.error != null){
                    Toast.makeText(applicationContext,newUser.error!!, Toast.LENGTH_SHORT).show()
                }else {
                    PrefUtils.storeUsernameID(this, newUser.userID!!)
                    PrefUtils.storeUsername(this, newUser.username!!)
                    PrefUtils.storePassword(this, newUser.password!!)
                    username_input_login.setText(PrefUtils.getUsername(this))
                    password_input_login.setText(PrefUtils.getPassword(this))
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }


            },{
                    error ->
                if (auto)Toast.makeText(applicationContext,R.string.err_login_msg, Toast.LENGTH_SHORT).show()
                Log.wtf("******", error.message.toString())

            })
    }
}
