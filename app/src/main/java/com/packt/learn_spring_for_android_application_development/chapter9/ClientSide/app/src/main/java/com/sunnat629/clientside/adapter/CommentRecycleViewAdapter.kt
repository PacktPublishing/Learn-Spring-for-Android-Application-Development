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
import com.sunnat629.clientside.model.Comment
import com.sunnat629.clientside.ui.PostDetailsActivity
import com.sunnat629.clientside.util.Constants.TIME_FORMAT
import java.text.SimpleDateFormat

class CommentRecycleViewAdapter(private var context: Context,
                                private var commentList: List<Comment>
):
    RecyclerView.Adapter<CommentRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.comment_item, viewGroup, false)

        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    fun setItems(commentList: List<Comment>) {
        this.commentList = emptyList()
        this.commentList = commentList
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val commentDetails = commentList[position]

        viewHolder.profileFullName.text = "${commentDetails.profile!!.firstName} ${commentDetails.profile!!.lastName} "
        viewHolder.username.text = commentDetails.profile!!.username
        viewHolder.commentedDate.text = SimpleDateFormat(TIME_FORMAT).format(commentDetails.commentCreatedTime!!)
        viewHolder.commentText.text = commentDetails.text

//        viewHolder.postRoot.setOnClickListener {
//            val intent = Intent(context, PostDetailsActivity::class.java)
//            intent.putExtra("postId", commentDetails.postId)
//            context.startActivity(intent)
//            Toast.makeText(context, commentDetails.profile!!.username, Toast.LENGTH_SHORT).show()
//        }
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val postRoot = view.findViewById(R.id.commentRoot) as ConstraintLayout

        val profileFullName = view.findViewById(R.id.profileFullNameComment_com) as TextView
        val username = view.findViewById(R.id.usernameComment) as TextView
        val commentedDate = view.findViewById(R.id.commentedDate) as TextView
        val commentText = view.findViewById(R.id.commentText_com) as TextView

    }
}
