package com.packt.learn_spring_for_android_application_development.chapter7

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        channel.send(0)
        delay(100)
        channel.send(1)
        delay(200)
    }
    val theFirstElement = channel.receive()
    delay(400)
    val theSecondElement = channel.receive()


    joinAll()
}
