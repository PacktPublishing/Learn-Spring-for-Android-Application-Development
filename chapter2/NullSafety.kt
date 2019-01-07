package com.packt.learn_spring_for_android_application_development.chapter2

/**
 * Created by ihor_kucherenko on 9/17/18.
 * https://github.com/KucherenkoIhor
 */
fun example1() {
    var name: String? = "Igor"
    name = null


    name?.length?.compareTo(4)

    name?.length?.compareTo(4) ?: { println("name is null") }()
}

