package com.sunnat629.mvvmroomexample.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sunnat629.mvvmroomexample.R
import com.sunnat629.mvvmroomexample.model.Users
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class UserListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)!!
    private var mUsers: List<Users> = emptyList() // Cached copy of users


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rowName: TextView = itemView.name
        val rowEmail: TextView = itemView.email
        val rowContactNumber: TextView = itemView.contactNumber
        val rowAddress: TextView = itemView.contactNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView: View = mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.rowName.text = mUsers[position].username
        holder.rowEmail.text = mUsers[position].email
        holder.rowContactNumber.text = mUsers[position].contactNumber
        holder.rowAddress.text = mUsers[position].address
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    internal fun setNewUser(users: List<Users>) {
        mUsers = users
        notifyDataSetChanged()
    }
}