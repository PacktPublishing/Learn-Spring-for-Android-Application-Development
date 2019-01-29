package com.sunnat629.mvvmroomexample.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.sunnat629.mvvmroomexample.R
import com.sunnat629.mvvmroomexample.model.Users
import kotlinx.android.synthetic.main.activity_new_user.*

class NewUserActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view!!.id == R.id.buttonSave){
            val intent = Intent()
            if (isTextFieldEmpty()){
                Snackbar.make(view, "Empty Field", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val users = Users(editUsername.text.toString(),
                    editEmail.text.toString(),
                    editContactID.text.toString(),
                    editAddress.text.toString())

                // If an instance of this Activity already exists, then it will be moved to the front.
                // If an instance does NOT exist, a new instance will be created.
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                intent.putExtra(getString(R.string.result_replay), users)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }

    private fun isTextFieldEmpty(): Boolean {
        return TextUtils.isEmpty(editUsername.text) ||
                TextUtils.isEmpty(editEmail.text) ||
                TextUtils.isEmpty(editContactID.text) ||
                TextUtils.isEmpty(editAddress.text)
    }
}
