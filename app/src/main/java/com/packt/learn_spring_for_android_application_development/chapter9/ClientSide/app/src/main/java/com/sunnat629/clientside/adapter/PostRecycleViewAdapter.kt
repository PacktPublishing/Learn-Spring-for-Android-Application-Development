package com.sunnat629.clientside.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.sunnat629.clientside.R
import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.ui.PostDetailsActivity
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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val postDetails = postList[position]

        viewHolder.profileFullName.text = "${postDetails.profile!!.firstName} ${postDetails.profile!!.lastName} "
        viewHolder.username.text = postDetails.profile!!.username
        viewHolder.postedDate.text = SimpleDateFormat(TIME_FORMAT).format(postDetails.postCreatedTime!!)
        viewHolder.postText.text = postDetails.text

        viewHolder.postRoot.setOnClickListener {
            val intent = Intent(context, PostDetailsActivity::class.java)
            intent.putExtra("postId", postDetails.postId)
            context.startActivity(intent)
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
