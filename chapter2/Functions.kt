package com.packt.learn_spring_for_android_application_development.chapter2

/**
 * Created by ihor_kucherenko on 9/13/18.
 * https://github.com/KucherenkoIhor
 */

fun firstClass() {
    println("First class function")
}

class A {
    fun classMember() {
        println("Class member")
    }
}

fun outer() {
    fun local() {
        println("Local")
    }

    local()
}

fun imperative() {
    val numbers = listOf(1, 4, 6, 2, 9)
    for (i in 0 until numbers.lastIndex) {
        if (numbers[i] > 4) {
            println(numbers)
        }
    }
}

fun declarative() {
    println(listOf(1, 4, 6, 2, 9).find { it > 4 })

    listOf(2, 3).map { }
}

fun A.extension() {
    println("Extension")
}

fun testExtension() {
    A().extension()
}

fun lambda() {
    val predicate: (Int) -> Unit = { println(it) }
    //val predicate = {x: Int -> println(x)}
    predicate(3)
}


class Numbers(val numbers: Array<Int>)

private var currentIndex = 0
operator fun Numbers.iterator(): Numbers {
    currentIndex = 0
    return this
}

operator fun Numbers.hasNext(): Boolean = currentIndex < numbers.lastIndex
operator fun Numbers.next(): Int = numbers[currentIndex++]


fun testForLoop() {
    val numbers = Numbers(arrayOf(1, 2, 3))
    for (item in numbers) {
        //......
    }
}

fun testWhileLoop() {
    val array = arrayOf(1, 2, 3)
    do {
        var index = 0
        println(array[index++])
    } while (index < array.lastIndex)
}


