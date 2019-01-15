package com.sunnat629.clientside

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sunnat629.clientside.adapter.PostListAdapter
import com.sunnat629.clientside.api.APIService
import com.sunnat629.clientside.repository.UserService
import com.sunnat629.clientside.repository.UserServiceImpl
import com.sunnat629.clientside.util.UtilMethods
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var username = "sunnat"
    var password = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val userService: UserService = UserServiceImpl().getUserServiceImplImpl(username,password)
//        getUserList(userService)
//        val profileService: ProfileService = APIService.getProfileServiceImplImpl(username,password)
//        profileAPICall(1)
        getAllPosts()
    }

    @SuppressLint("CheckResult")
    private fun getAllPosts() {
        val observable = APIService.postAPICall(username,password)
            .getPostList()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                postList ->
                val adapter = PostListAdapter(this@MainActivity, postList)
                displayList.adapter = adapter
            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())

            })
    }

    @SuppressLint("CheckResult")
    private fun getUserList(userService: UserService) {
        if(UtilMethods.isConnectedToInternet(this)){

            val observable = UserServiceImpl()
                .getUserServiceImplImpl(username,password).getUserList()

            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    userList -> println(userList[0].email)

                },{
                    error -> println(error.message)
                })



//            val call: Call<List<UserModel>> = userService.getUserList()
//            call.enqueue(object: Callback<List<UserModel>> {
//                override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
//                    Log.e("PACKTPUB", t.message)
//                    UtilMethods.hideLoading()
//                    UtilMethods.showLongToast(this@MainActivity, "Internet Nai")
//                }
//
//                override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
////                displayList.text = response.body().toString()
//                    UtilMethods.hideLoading()
//
//                    val adapter = UserListAdapter(this@MainActivity, response.body())
//                    displayList.adapter = adapter
//                }
//            })

        }else{
            UtilMethods.showLongToast(this, "No Internet Connection!")
        }
    }

    @SuppressLint("CheckResult")
    private fun userApiCall(userID: Int){
        if(UtilMethods.isConnectedToInternet(this)){
            UtilMethods.showLoading(this)
            val observable = APIService
                .profileAPICall(username,password)
                .getUserList()
//                .getProfileServiceImplImpl()
//                .getTest()
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userResponse ->
                    UtilMethods.hideLoading()

//                    val adapter = UserListAdapter(this@MainActivity, userResponse)
//                    displayList.adapter = adapter

                    Log.i("******", userResponse[0].email)

                    /** userResponse is response data class*/

                }, { error ->
                    UtilMethods.hideLoading()
                    Log.wtf("******", error.message.toString())

                    UtilMethods.showLongToast(this, error.message.toString())
                }
                )
        }else{
            UtilMethods.showLongToast(this, "No Internet Connection!")
        }
    }
}
