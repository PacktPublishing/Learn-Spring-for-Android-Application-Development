package com.sunnat629.clientside.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.sunnat629.clientside.R
import com.sunnat629.clientside.adapter.PostRecycleViewAdapter
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.model.Profile
import com.sunnat629.clientside.repository.UserService
import com.sunnat629.clientside.repository.UserServiceImpl
import com.sunnat629.clientside.util.UtilMethods
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var username = "sunnat"
    var password = "12345"
    private val disposable = CompositeDisposable()
    private lateinit var postRecycleViewAdapter: PostRecycleViewAdapter
    private var postList: List<Post> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleName()


        fabMain.setOnClickListener { view ->
            submitPost()
            Snackbar.make(view, "Post Submitted!!!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        println("${postList.size}")
        val mLayoutManager = LinearLayoutManager(this)
        displayList.layoutManager = mLayoutManager
        displayList.setHasFixedSize(true)
        postRecycleViewAdapter = PostRecycleViewAdapter(this, postList)
        displayList.adapter = postRecycleViewAdapter



//        val userService: UserService = UserServiceImpl().getUserServiceImplImpl(username,password)
//        getUserList(userService)
//        val profileService: ProfileService = APIClient.getProfileServiceImplImpl(username,password)
//        profileAPICall(1)
//        getAllPosts()
        registerUser()
        getAllPosts()
    }

    @SuppressLint("CheckResult")
    private fun getAllPosts() {
        disposable.add(
            APIClient.postAPICall(username,password)
            .getPostList()
                .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                newPostList ->
                postList = newPostList

                postRecycleViewAdapter.setItems(newPostList)
                postRecycleViewAdapter.notifyDataSetChanged()

            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())

            })
        )
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
            val observable = APIClient
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

    @SuppressLint("CheckResult")
    private fun submitPost(){
        APIClient.postAPICall(username,password)
            .submitNewPost(1, "THISASDSA D")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    newPostList ->
                postList = newPostList

                postRecycleViewAdapter.setItems(newPostList)
                postRecycleViewAdapter.notifyDataSetChanged()

            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())

            })
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
                        postList ->
                    Log.wtf("******", postList.toString())
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
