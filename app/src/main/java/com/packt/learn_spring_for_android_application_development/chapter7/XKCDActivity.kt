package com.packt.learn_spring_for_android_application_development.chapter7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.packt.learn_spring_for_android_application_development.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class XKCDActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var lifecycleAwareJob: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + lifecycleAwareJob

    private val imageView: ImageView by lazy(LazyThreadSafetyMode.NONE) {
        findViewById<ImageView>(R.id.iv)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xkcd)
        lifecycleAwareJob = Job()

        launch {
            val comic = awaitComic()
            if (comic.img == null) {
                return@launch
            }
            val image = awaitImage(comic.img)
            imageView.setImageBitmap(image)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleAwareJob.cancel()
    }
}

