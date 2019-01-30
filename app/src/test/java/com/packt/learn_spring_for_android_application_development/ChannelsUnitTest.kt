package com.packt.learn_spring_for_android_application_development

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.*

class ChannelsUnitTest {

    @Test
    fun channelBasics() = runBlocking<Unit> {
        val channel = Channel<Int>()
        launch {
            println("send 0 ${Date().toGMTString()}")
            channel.send(0)
            delay(1000)
            println("send 1 ${Date().toGMTString()}")
            channel.send(1)
        }
        delay(3000)
        val theFirstElement = channel.receive()
        println("receive $theFirstElement ${Date().toGMTString()}")
        delay(4000)
        val theSecondElement = channel.receive()
        println("receive $theSecondElement ${Date().toGMTString()}")
    }

    @Test
    fun channelIterator() = runBlocking<Unit> {
        val channel = Channel<Int>()
        launch {
            (0..5).forEach {
                channel.send(it)
            }
            channel.cancel()
        }
        for (value in channel) {
            println(value)
        }
    }

    @Test
    fun producerExample() = runBlocking<Unit> {
        val numbers = numbersProduce()
        for (value in numbers) {
            println(value)
        }
        numbers.cancel()
    }

    suspend fun numbersProduce(): ReceiveChannel<Int> = GlobalScope.produce {
        launch {
            (0..10).forEach {
                send(it)
            }
        }
    }

    suspend fun numberConsumer() = GlobalScope.actor<Int> {
        var counter = 0
        for (value in channel) {
            counter += value
            println(counter)
        }
    }

    @Test
    fun actorExample() = runBlocking<Unit> {
        val actor = numberConsumer()
        (0..10).forEach {
            launch {
                actor.send(it)
            }
        }
    }
}