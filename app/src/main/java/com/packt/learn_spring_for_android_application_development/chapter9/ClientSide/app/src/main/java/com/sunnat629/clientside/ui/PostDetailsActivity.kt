package com.sunnat629.clientside.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.sunnat629.clientside.R
import com.sunnat629.clientside.adapter.CommentRecycleViewAdapter
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.model.Comment
import com.sunnat629.clientside.util.Constants
import com.sunnat629.clientside.util.PrefUtils
import com.sunnat629.clientside.util.UtilMethods
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_post_details.*
import java.text.SimpleDateFormat


class PostDetailsActivity : AppCompatActivity() {

    private var postId:Long = -1
    private var commentList: List<Comment> = listOf()
    private lateinit var commentRecycleViewAdapter: CommentRecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        setTitleName()

        if(intent.extras!=null){
            postId = intent.extras.getLong("postId")
        }

        Log.wtf("******", postId.toString())

        displayList_com.layoutManager = LinearLayoutManager(this)
        displayList_com.setHasFixedSize(true)
        commentRecycleViewAdapter = CommentRecycleViewAdapter(this, commentList)
        displayList_com.adapter = commentRecycleViewAdapter

        fabMainComment.setOnClickListener {
            showNoteDialog()
        }

        getPostById(postId)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.postedDateSingle -> {
                getPostById(postId)
            }
        }
        return true
    }

    private fun setTitleName() {
        val toolbar = findViewById<View>(R.id.toolbar_pd) as Toolbar
        toolbar.title = getString(R.string.title_post_details)
        setSupportActionBar(toolbar)
    }


    @SuppressLint("InflateParams")
    private fun showNoteDialog() {
        val layoutInflaterAndroid = LayoutInflater.from(applicationContext)
        val view = layoutInflaterAndroid.inflate(R.layout.post_dialog, null)

        val alertDialogBuilderUserInput = AlertDialog.Builder(this@PostDetailsActivity)
        alertDialogBuilderUserInput.setView(view)

        val inputNote = view.findViewById(R.id.post) as EditText
        val dialogTitle = view.findViewById(R.id.dialog_title) as TextView
        dialogTitle.text = getString(R.string.lbl_new_comment_title)

        alertDialogBuilderUserInput
            .setCancelable(false)
            .setPositiveButton( "Comment") { _, _ -> }
            .setNegativeButton("cancel") { dialogBox, _ -> dialogBox.cancel() }

        val alertDialog = alertDialogBuilderUserInput.create()
        alertDialog.show()

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(View.OnClickListener {
            // Show toast message when no text is entered
            if (TextUtils.isEmpty(inputNote.text.toString())) {
                Toast.makeText(this@PostDetailsActivity, "Enter Comment!", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            } else {
                submitComment(postId, inputNote.text.toString())
                alertDialog.dismiss()
            }
        })
    }

    @SuppressLint("CheckResult")
    private fun getPostById(id: Long){
        UtilMethods.showLoading(this)
        APIClient.postAPICall(PrefUtils.getUsername(this)!!, PrefUtils.getPassword(this)!!)
            .getPostById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    post ->
                postText_pd.text = post.text
                profileFullNamePost_pd.text = "${post.profile!!.firstName} ${post.profile!!.lastName}"
                usernamePost_pd.text = post.profile!!.username
                postedDate_pd.text = SimpleDateFormat(Constants.TIME_FORMAT).format(post.postCreatedTime!!)

                commentList = post.comment!!

                Log.wtf("******", commentList.toString())
                commentRecycleViewAdapter.setItems(commentList)
                commentRecycleViewAdapter.notifyDataSetChanged()

                UtilMethods.hideLoading()
            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())
                Toast.makeText(applicationContext, error.message.toString(), Toast.LENGTH_SHORT).show()
            })
    }

    @SuppressLint("CheckResult")
    private fun submitComment(id: Long, text: String){
        UtilMethods.showLoading(this)
        APIClient.commentAPICall(PrefUtils.getUsername(this)!!, PrefUtils.getPassword(this)!!)
            .postCommentByPostId(id, PrefUtils.getUsernameID(this)!!,text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    newPostList ->
                commentList = newPostList.comment!!

                Log.wtf("******", commentList.toString())
                commentRecycleViewAdapter.setItems(commentList)
                commentRecycleViewAdapter.notifyDataSetChanged()
                UtilMethods.hideLoading()
            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())
                Toast.makeText(applicationContext, error.message.toString(), Toast.LENGTH_SHORT).show()
            })
    }
}
