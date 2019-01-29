package com.packt.learn_spring_for_android_application_development.chapter8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.packt.learn_spring_for_android_application_development.R
import com.jakewharton.rxbinding3.widget.textChanges

class RxActivity : AppCompatActivity() {

    private val editText by lazy(LazyThreadSafetyMode.NONE) {
        findViewById<EditText>(R.id.editText)
    }

    private val textView by lazy(LazyThreadSafetyMode.NONE) {
        findViewById<TextView>(R.id.textView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)
        editText
                .textChanges()
                .subscribe { textView.text = it }
        }
}
