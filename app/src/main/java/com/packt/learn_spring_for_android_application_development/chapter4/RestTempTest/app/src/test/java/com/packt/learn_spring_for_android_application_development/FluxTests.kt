package com.packt.learn_spring_for_android_application_development

import android.util.Log
import com.packt.learn_spring_for_android_application_development.chapter8.ListenerActivity
import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

class FluxTests {

    @Test
    fun fluxTest() {
        Flux.fromArray(arrayOf(1, 2, 3))
                .filter { it % 2 == 1 }
                .map { it * it }
                .reduce { sum, item -> sum + item }
                .flatMap { Mono.just(it) }
                .subscribe { println(it) }
    }

    @Test
    fun flatMerge() {
        Flux.fromArray(arrayOf(1, 2, 3))
                .flatMap { Mono.just(it).delayElement(Duration.ofSeconds(1)) }
                .subscribe { println(it) }
    }
}