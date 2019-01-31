package com.packt.learn_spring_for_android_application_development

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.junit.Test


class RxTest {

    @Test
    fun flowable() {
        Flowable.fromIterable(listOf(1, 2, 3))
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { println(it) }
    }

    @Test
    fun observable() {
        Observable.fromIterable(listOf(1, 2, 3))
                .subscribe { println(it) }
    }

    @Test
    fun single() {
        Single.just(1).subscribe(Consumer<Int> { println(it) })
    }

    @Test
    fun maybe() {
        Maybe.just(1)
                .map { item -> item + 1 }
                .filter { item -> item == 1 }
                .defaultIfEmpty(4)
                .test()
                .assertResult(4)
    }

    @Test
    fun completable() {
        Completable.fromAction { Database.delete() }
                .test()
                .assertComplete()
    }

    object Database {
        fun delete() {

        }
    }
}