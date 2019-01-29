package com.packt.learn_spring_for_android_application_development.chapter7

import java.util.concurrent.Executors

fun main() {
    val executor = Executors.newSingleThreadExecutor()
    executor.submit { loadImage() }
    executor.submit { loadImage() }
}