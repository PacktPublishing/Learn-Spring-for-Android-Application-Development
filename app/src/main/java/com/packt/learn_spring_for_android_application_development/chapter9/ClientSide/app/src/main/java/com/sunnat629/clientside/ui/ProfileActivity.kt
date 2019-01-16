package com.sunnat629.clientside.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.sunnat629.clientside.R
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.model.Profile
import com.sunnat629.clientside.util.PrefUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private var username: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setTitleName()

        username = PrefUtils.getUsername(this)!!
        password = PrefUtils.getPassword(this)!!
        Log.wtf("*********", "${PrefUtils.getUsernameID(this)} $username $password")
        getUser()
    }

    @SuppressLint("CheckResult")
    private fun getUser(){
        APIClient.profileAPICall(username,password)
            .getUserById(PrefUtils.getUsernameID(this)!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    myUser ->

                usernamePro.text = myUser.username
                profileFullNamePro.text = "${myUser.firstName}  ${myUser.lastName}"
                emailPro.text = myUser.email
                contactNumberPro.text = myUser.contactNumber
                countryPro.text = myUser.country
            },{
                    error ->
                Log.wtf("******", error.message.toString())

            })
    }

    private fun setTitleName() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = getString(R.string.title_profile)
        setSupportActionBar(toolbar)
    }

}
