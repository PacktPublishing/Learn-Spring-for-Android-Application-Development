package com.packt.learn_spring_for_android_application_development.chapter2

/**
 * Created by ihor_kucherenko on 9/16/18.
 * https://github.com/KucherenkoIhor
 */
fun ranges() {
    for (i in 0..100) {
        // .....
    }

    (0..100)
            .filter { it > 50 }
            .map { it * 2 }
}