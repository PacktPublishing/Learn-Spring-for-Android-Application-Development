package com.packt.learn_spring_for_android_application_development.chapter7

import kotlinx.coroutines.experimental.*
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val executor = Executors.newSingleThreadExecutor()
    executor.submit { loadImage() }
    executor.submit { loadImage() }
}