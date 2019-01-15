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
import com.sunnat629.clientside.util.UtilMethods
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
        registerUser()

        username = PrefUtils.getUsername(this)!!
        password = PrefUtils.getPassword(this)!!
        Log.wtf("*********", "${PrefUtils.getUsernameID(this)} $username $password")
        getUser()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.profileMenu -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return true
    }
    @SuppressLint("CheckResult")
    private fun registerUser(){
        val newProfile = Profile(null, "sunnat629", "123456", "s@gmail.com",
            null, "Mohi Us", "Sunnat", "123456789", "Bangladesh")
        APIClient.profileAPICall(username,password)
            .registerProfile(newProfile)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    newUser ->
                Log.wtf("******", newUser.duplicate!!)


            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())

            })
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
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())

            })
    }

    private fun setTitleName() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }

}
