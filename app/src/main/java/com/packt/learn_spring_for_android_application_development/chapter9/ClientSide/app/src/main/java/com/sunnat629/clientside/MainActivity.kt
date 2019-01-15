package com.sunnat629.clientside

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.sunnat629.clientside.adapter.UserListAdapter
import com.sunnat629.clientside.model.UserModel
import com.sunnat629.clientside.repository.UserService
import com.sunnat629.clientside.repository.UserServiceImpl


class MainActivity : AppCompatActivity() {

    var username = "sunnat629"
    var password = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userService: UserService = UserServiceImpl().getUserServiceImplImpl(username,password)
        getUserList(userService)
    }

    private fun getUserList(userService: UserService) {
        if(UtilMethods.isConnectedToInternet(this)){
            UtilMethods.showLoading(this)
            val call: Call<List<UserModel>> = userService.getUserList()
            call.enqueue(object: Callback<List<UserModel>> {
                override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                    Log.e("PACKTPUB", t.message)
                    UtilMethods.hideLoading()
                    UtilMethods.showLongToast(this@MainActivity, "Internet Nai")
                }

                override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
//                displayList.text = response.body().toString()
                    UtilMethods.hideLoading()

                    val adapter = UserListAdapter(this@MainActivity, response.body())
                    displayList.adapter = adapter
                }
            })

        }else{
            UtilMethods.showLongToast(this, "No Internet Connection!")
        }
    }
}
