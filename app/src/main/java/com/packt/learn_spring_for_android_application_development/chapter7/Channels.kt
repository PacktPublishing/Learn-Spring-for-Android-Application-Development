package com.packt.learn_spring_for_android_application_development.chapter7

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*
import kotlinx.coroutines.experimental.channels.ChannelIterator
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.selects.SelectClause1
import kotlinx.coroutines.experimental.selects.SelectClause2
import kotlinx.coroutines.experimental.selects.select

fun main(args: Array<String>) = runBlocking<Unit> {
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
