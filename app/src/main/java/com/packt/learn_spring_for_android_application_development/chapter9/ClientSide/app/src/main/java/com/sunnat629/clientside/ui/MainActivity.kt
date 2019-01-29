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
import android.widget.Toast
import com.sunnat629.clientside.R
import com.sunnat629.clientside.adapter.PostRecycleViewAdapter
import com.sunnat629.clientside.api.APIClient
import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.util.PrefUtils
import com.sunnat629.clientside.util.UtilMethods
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private lateinit var postRecycleViewAdapter: PostRecycleViewAdapter
    private var postList: List<Post> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleName()

        fabMain.setOnClickListener {
            showNoteDialog()
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
            }
            R.id.postUpdate -> {
                getAllPosts()
            }
        }
        return true
    }

    @SuppressLint("CheckResult")
    private fun getAllPosts() {
        UtilMethods.showLoading(this)

        disposable.add(
            APIClient.postAPICall(PrefUtils.getUsername(this)!!, PrefUtils.getPassword(this)!!)
            .getPostList()
                .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                newPostList ->
                postRecycleViewAdapter.setItems(newPostList)
                postRecycleViewAdapter.notifyDataSetChanged()
                UtilMethods.hideLoading()
                toggleEmptyNotes(newPostList.isNotEmpty())

            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())
                Toast.makeText(applicationContext, error.message.toString(), Toast.LENGTH_SHORT).show()
            })
        )
    }

    @SuppressLint("CheckResult")
    private fun submitPost(id: Long, text: String){
        UtilMethods.showLoading(this)
        APIClient.postAPICall(PrefUtils.getUsername(this)!!, PrefUtils.getPassword(this)!!)
            .submitNewPost(id, text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    newPostList ->
                postRecycleViewAdapter.setItems(newPostList)
                postRecycleViewAdapter.notifyDataSetChanged()
                UtilMethods.hideLoading()
                toggleEmptyNotes(newPostList.isNotEmpty())

            },{
                    error ->
                UtilMethods.hideLoading()
                Log.wtf("******", error.message.toString())
                Toast.makeText(applicationContext, error.message.toString(), Toast.LENGTH_SHORT).show()
            })
    }

    private fun toggleEmptyNotes(notEmpty: Boolean) {
        if (notEmpty) {
            txt_empty_notes_view.visibility = View.GONE
        } else {
            txt_empty_notes_view.visibility = View.VISIBLE
        }
    }

    private fun setTitleName() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }

    private fun showNoteDialog() {
        val layoutInflaterAndroid = LayoutInflater.from(applicationContext)
        val view = layoutInflaterAndroid.inflate(R.layout.post_dialog, null)

        val alertDialogBuilderUserInput = AlertDialog.Builder(this@MainActivity)
        alertDialogBuilderUserInput.setView(view)

        val inputNote = view.findViewById(R.id.post) as EditText

        alertDialogBuilderUserInput
            .setCancelable(false)
            .setPositiveButton( "Post") { _, _ -> }
            .setNegativeButton("cancel") { dialogBox, _ -> dialogBox.cancel() }

        val alertDialog = alertDialogBuilderUserInput.create()
        alertDialog.show()

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(View.OnClickListener {
            // Show toast message when no text is entered
            if (TextUtils.isEmpty(inputNote.text.toString())) {
                Toast.makeText(this@MainActivity, "Enter post!", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            } else {
                submitPost(PrefUtils.getUsernameID(this)!!, inputNote.text.toString())
                alertDialog.dismiss()
            }
        })
    }
}
