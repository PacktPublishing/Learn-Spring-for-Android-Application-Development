package com.sunnat629.clientside.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
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
import com.sunnat629.clientside.adapter.PostRecycleViewAdapter
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.model.Profile
import com.sunnat629.clientside.repository.UserService
import com.sunnat629.clientside.repository.UserServiceImpl
import com.sunnat629.clientside.util.PrefUtils
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

        PrefUtils.storeUsernameID(this, 1)
        PrefUtils.storeUsername(this, username)
        PrefUtils.storePassword(this, password)


        fabMain.setOnClickListener { view ->
            showNoteDialog(false, null, -1)

            Snackbar.make(view, "Post Submitted!!!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        displayList.layoutManager = LinearLayoutManager(this)
        displayList.setHasFixedSize(true)
        postRecycleViewAdapter = PostRecycleViewAdapter(this, postList)
        displayList.adapter = postRecycleViewAdapter

        getAllPosts()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.profileMenu -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return true
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
    private fun submitPost(id: Long, text: String){
        APIClient.postAPICall(username,password)
            .submitNewPost(id, text)
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

    private fun setTitleName() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }

    private fun showNoteDialog(shouldUpdate: Boolean, post: Post?, position: Int) {
        val layoutInflaterAndroid = LayoutInflater.from(applicationContext)
        val view = layoutInflaterAndroid.inflate(R.layout.post_dialog, null)

        val alertDialogBuilderUserInput = AlertDialog.Builder(this@MainActivity)
        alertDialogBuilderUserInput.setView(view)

        val inputNote = view.findViewById(R.id.post) as EditText
        val dialogTitle = view.findViewById(R.id.dialog_title) as TextView
        dialogTitle.text = if (!shouldUpdate) getString(R.string.lbl_new_post_title) else getString(R.string.lbl_edit_post_title)

        if (shouldUpdate && post != null) {
            inputNote.setText(post.text)
        }
        alertDialogBuilderUserInput
            .setCancelable(false)
            .setPositiveButton(if (shouldUpdate) "update" else "save"
            ) { _, _ -> }
            .setNegativeButton("cancel"
            ) { dialogBox, _ -> dialogBox.cancel() }

        val alertDialog = alertDialogBuilderUserInput.create()
        alertDialog.show()

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(View.OnClickListener {
            // Show toast message when no text is entered
            if (TextUtils.isEmpty(inputNote.getText().toString())) {
                Toast.makeText(this@MainActivity, "Enter post!", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            } else {
                alertDialog.dismiss()
            }

            // check if user updating post
            if (shouldUpdate && post != null) {
                // update post by it's id
//                updateNote(post!!.getId(), inputNote.text.toString(), position)
            } else {
                // create new post
                submitPost(1, inputNote.text.toString())
            }
        })
    }
}
