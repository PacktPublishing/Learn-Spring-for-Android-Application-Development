package com.packt.learn_spring_for_android_application_development.chapter7

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


suspend fun loadUserDetails(): User {
    delay(3000)
    return User(0, "avatar")
}

suspend fun loadImage(avatar: String): Image {
    delay(3000)
    return Image()
}

fun main(args: Array<String>) = runBlocking {
    val user = GlobalScope.async { loadUserDetails() }.await()
    val image = async { loadImage(user.avatar) }.await()
    showImage(image)
}