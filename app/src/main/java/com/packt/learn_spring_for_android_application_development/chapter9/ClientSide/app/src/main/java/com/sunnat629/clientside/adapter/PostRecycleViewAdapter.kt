package com.sunnat629.clientside.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.sunnat629.clientside.R
import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.util.Constants.TIME_FORMAT
import java.text.SimpleDateFormat

class PostRecycleViewAdapter(private var context: Context,
                             private var postList: List<Post>
):
    RecyclerView.Adapter<PostRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.post_item, viewGroup, false)

        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setItems(postList: List<Post>) {
        this.postList = emptyList()
        this.postList = postList
    }

    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val userDetails = postList[position]


//        val time: Instant = Instant.parse(userDetails.postCreatedTime!!)
////        val myDate = Date.from(time)
//        val formatter = SimpleDateFormat("dd MM yyyy HH:mm:ss")
//        val formattedDate = formatter.format(time)

        viewHolder.profileFullName.text = "${userDetails.profile!!.firstName} ${userDetails.profile!!.lastName} "
        viewHolder.username.text = userDetails.profile!!.username
        viewHolder.postedDate.text = SimpleDateFormat(TIME_FORMAT).format(userDetails.postCreatedTime!!)
        viewHolder.postText.text = userDetails.text

        viewHolder.postRoot.setOnClickListener {
            Toast.makeText(context, userDetails.profile!!.username, Toast.LENGTH_SHORT).show()
        }
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val postRoot = view.findViewById(R.id.postRoot) as ConstraintLayout

        val profileFullName = view.findViewById(R.id.profileFullNamePost) as TextView
        val username = view.findViewById(R.id.usernamePost) as TextView
        val postedDate = view.findViewById(R.id.postedDate) as TextView
        val postText = view.findViewById(R.id.postText) as TextView

    }
}
