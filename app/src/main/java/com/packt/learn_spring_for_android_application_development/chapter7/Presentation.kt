package com.packt.learn_spring_for_android_application_development.chapter7

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import kotlin.coroutines.experimental.suspendCoroutine


/**
 * Created by ihor_kucherenko on 10/9/18.
 * https://github.com/KucherenkoIhor
 */
data class Comic @JvmOverloads constructor(
        val month: String? = null,
        val num: Int? = null,
        val link: String? = null,
        val year: String? = null,
        val news: String? = null,
        val safe_title: String? = null,
        val transcript: String? = null,
        val alt: String? = null,
        val img: String? = null,
        val title: String? = null,
        val day: String? = null
)

fun loadComic(callback: (Comic) -> Unit) {
    Executors.newSingleThreadExecutor().submit {
        val result = loadComic()
        Handler(Looper.getMainLooper()).post { callback(result) }
    }
}

fun loadComic(): Comic {
    val url = "https://xkcd.com/info.0.json"
    val restTemplate = RestTemplate()
    restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())
    return restTemplate.getForObject(url, Comic::class.java)
}

fun loadBitmap(path: String?): Bitmap {
    val url = URL(path)
    val connection = url.openConnection() as HttpURLConnection
    connection.doInput = true
    connection.connect()
    val input = connection.inputStream
    return BitmapFactory.decodeStream(input)
}

fun loadImage(path: String, callback: (Bitmap) -> Unit) {
    Executors.newSingleThreadExecutor().submit {
        val bitmap = loadBitmap(path)
        Handler(Looper.getMainLooper()).post { callback(bitmap) }
    }
}

suspend fun awaitComic() = suspendCoroutine<Comic> { continuation ->
    try {
        loadComic { comic -> continuation.resume(comic) }
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}

suspend fun awaitImage(path: String) = suspendCoroutine<Bitmap> { continuation ->
    try {
        loadImage(path) { bitmap: Bitmap ->
            continuation.resume(bitmap)
        }
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}