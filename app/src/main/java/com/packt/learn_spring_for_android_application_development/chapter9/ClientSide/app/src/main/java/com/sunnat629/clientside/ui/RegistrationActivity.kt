package com.sunnat629.clientside.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.sunnat629.clientside.R
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.model.Profile
import com.sunnat629.clientside.util.PrefUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_registration.*


class RegistrationActivity : AppCompatActivity() {


    private var username: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        username_input_reg.addTextChangedListener(MyTextWatcher(username_input_reg))

        reg_submit.setOnClickListener {
            submitForm()
        }
        registerUser()

        already_reg.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    /**
     * Validating form
     */
    private fun submitForm() {
        if (!validateName()) {
            return
        } else if (!validateEmail()) {
            return
        } else if (!validatePassword()) {
            return
        }else{
            registerUser()
        }

        Toast.makeText(applicationContext, "Thank You!", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("CheckResult")
    private fun registerUser(){
        val newProfile = Profile(null,
            username_input_reg.text.toString(),
            password_input_reg.text.toString(),
            email_input_reg.text.toString(),
            null,
            first_name_input_reg.text.toString(),
            last_name_input_reg.text.toString(),
            contact_input_reg.text.toString(),
            country_input_reg.text.toString())

            APIClient.newProfileAPICall()
            .registerProfile(newProfile)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    newUser ->

                if(newUser.duplicate != null){
                    Toast.makeText(applicationContext,newUser.duplicate!!, Toast.LENGTH_SHORT).show()
                }else {
                    PrefUtils.storeUsernameID(this, newUser.userID!!)
                    PrefUtils.storeUsername(this, newUser.username!!)
                    PrefUtils.storePassword(this, newUser.password!!)
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }


            },{
                    error ->
                Toast.makeText(applicationContext,error.message.toString(), Toast.LENGTH_SHORT).show()
                Log.wtf("******", error.message.toString())

            })
    }

    private fun validateName(): Boolean {
        if (username_input_reg.text.toString().trim().isEmpty()) {
            username_title_reg.error = getString(R.string.err_msg_name)
            requestFocus(username_input_reg)
            return false
        } else {
            username_title_reg.isErrorEnabled = false
        }

        return true
    }

    private fun validateEmail(): Boolean {

        if (email_input_reg.text.toString().trim().isEmpty() || !isValidEmail(email_input_reg.text.toString().trim())) {
            email_title_reg.error = getString(R.string.err_msg_email)
            requestFocus(email_input_reg)
            return false
        } else {
            email_title_reg.isErrorEnabled = false
        }

        return true
    }

    private fun validatePassword(): Boolean {
        if (password_input_reg.text.toString().trim().isEmpty()
        || con_password_input_reg.text.toString().trim().isEmpty()) {

            if (password_input_reg.text.toString().trim()
                == con_password_input_reg.text.toString().trim()){
                password_title_reg.error = getString(R.string.err_match_password)
                requestFocus(password_title_reg)
            }

            password_title_reg.error = getString(R.string.err_msg_password)
            requestFocus(password_title_reg)
            return false
        } else {
            password_title_reg.isErrorEnabled = false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    private inner class MyTextWatcher (private val view: View) : TextWatcher {

        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

        override fun afterTextChanged(editable: Editable) {
            when (view.id) {
                R.id.username_input_reg -> validateName()
                R.id.email_input_reg -> validateEmail()
                R.id.password_input_reg -> validatePassword()
            }
        }
    }
}
