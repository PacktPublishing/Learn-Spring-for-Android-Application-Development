package com.packt.learn_spring_for_android_application_development.chapter8

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.annotation.UiThread
import android.widget.ImageView
import android.widget.Toast
import com.packt.learn_spring_for_android_application_development.R
import com.packt.learn_spring_for_android_application_development.chapter7.Comic
import com.packt.learn_spring_for_android_application_development.chapter7.loadBitmap
import com.packt.learn_spring_for_android_application_development.chapter7.loadComic
import org.reactivestreams.Subscriber
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

class XKCDActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xkcd2)

        val UIScheduler = Schedulers.fromExecutor { runnable -> Handler(Looper.getMainLooper()).post(runnable) }

        Mono.fromDirect<Comic> { subscriber -> subscriber.onNext(loadComic()) }
                .map { comic -> comic.img }
                .flatMap { path -> Mono.fromDirect<Bitmap> { subscriber -> subscriber.onNext(loadBitmap(path)) } }
                .subscribeOn(Schedulers.single())
                .publishOn(UIScheduler)
                .subscribe { bitmap -> findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap) }


    }
}
