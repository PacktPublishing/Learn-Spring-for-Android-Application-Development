package com.sunnat629.clientside.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.sunnat629.clientside.R
import com.sunnat629.clientside.R.id.name
import com.sunnat629.clientside.model.Post

class PostListAdapter(
    context: Context,
    private val postList: List<Post>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.post_item, parent, false)

        val profileFullName = rowView.findViewById(R.id.profileFullName) as TextView
        val username = rowView.findViewById(R.id.username) as TextView
        val postedDate = rowView.findViewById(R.id.postedDate) as TextView
        val postText = rowView.findViewById(R.id.postText) as TextView

        val userDetails = getItem(position) as Post

        profileFullName.text = "${userDetails.profile!!.firstName} ${userDetails.profile!!.lastName} "
        username.text = userDetails.profile!!.username
        postedDate.text = userDetails.postCreatedTime
        postText.text = userDetails.text

        return rowView
    }

    override fun getItem(position: Int): Any {
        return postList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return postList.size
    }
}
