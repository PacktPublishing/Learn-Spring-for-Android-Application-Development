package com.sunnat629.testingwithespresso

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class UserItemAdapter(private var context: Context,
                      val userList : ArrayList<User>):
    RecyclerView.Adapter<UserItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.user_item, p0, false)

        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.userID.text = userList[p1].userID.toString()
        p0.username.text = userList[p1].username
        p0.userRoot.setOnClickListener {
            Toast.makeText(context, userList[p1].username, Toast.LENGTH_SHORT).show()
        }
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userID = view.findViewById(R.id.userID) as TextView
        val username = view.findViewById(R.id.username) as TextView
        val userRoot = view.findViewById(R.id.userRoot) as ConstraintLayout
    }
}