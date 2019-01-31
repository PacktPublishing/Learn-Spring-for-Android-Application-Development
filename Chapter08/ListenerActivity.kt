package com.packt.learn_spring_for_android_application_development.chapter8

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.packt.learn_spring_for_android_application_development.R
import reactor.core.Disposable
import reactor.core.publisher.Flux

class ListenerActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)
//        findViewById<Button>(R.id.button).setOnClickListener {
//            Toast.makeText(this, "Clicked!", Toast.LENGTH_LONG).show()
//        }

        disposable = Flux.from<Unit> { subscriber ->
            findViewById<View>(R.id.button).setOnClickListener {
                subscriber.onNext(Unit)
            }
        }.subscribe {
            Toast.makeText(this, "Clicked!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
