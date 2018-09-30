package com.packt.learn_spring_for_android_application_development.chapter7

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

class Image

fun loadImage() : Image {
    Thread.sleep(3000)
    return Image()
}

fun main(args: Array<String>) = runBlocking {
    val subTask1 = GlobalScope.async { loadImage() }
    val subTask2 = GlobalScope.async { loadImage() }
    val subTask3 = GlobalScope.async { loadImage() }

    showImages(subTask1.await(), subTask2.await(), subTask3.await())
}

fun showImages(image1: Image, image2: Image, image3: Image) {
    // .......
}