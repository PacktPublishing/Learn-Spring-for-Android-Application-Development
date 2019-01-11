package com.sunnat629.testingwithespresso

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val userList: ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUserName()

        userLists.layoutManager = LinearLayoutManager(this)
        userLists.setHasFixedSize(true)
        userLists.adapter = UserItemAdapter(this, userList)
    }

    private fun addUserName() {
        for (i in 1..100){
            userList.add(User(i, "User Name$i"))
        }
    }
}
