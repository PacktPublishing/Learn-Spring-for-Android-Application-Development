package com.packt.learn_spring_for_android_application_development.chapter2

/**
 * Created by ihor_kucherenko on 9/12/18.
 * https://github.com/KucherenkoIhor
 */


val readOnly = 3
var mutable = 3

fun changeMutable() {
    mutable = 4
}

class Foo {
    val readOnly = 3
    var mutable = 3

    fun changeMutable() {
        mutable = 4
    }
}

class Bar {
    companion object {
        const val NAME = "Igor"

        fun printName() = println(NAME)
    }
}

fun test() {
    Bar.NAME
    Bar.printName()
}




//fun collection() {
//    List()
//}