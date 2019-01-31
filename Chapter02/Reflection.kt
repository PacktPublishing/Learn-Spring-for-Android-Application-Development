package com.packt.learn_spring_for_android_application_development.chapter2

import kotlin.reflect.KClass

/**
 * Created by ihor_kucherenko on 9/17/18.
 * https://github.com/KucherenkoIhor
 */


val reference: KClass<String> = String::class

fun isOdd(number: Int): Boolean = number % 2 == 0
val odds = listOf(1, 2, 3, 4, 5).filter(::isOdd)

val referenceToOddsPreperty = ::odds