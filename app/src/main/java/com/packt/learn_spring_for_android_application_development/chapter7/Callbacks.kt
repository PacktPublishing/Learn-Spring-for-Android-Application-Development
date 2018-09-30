package com.packt.learn_spring_for_android_application_development.chapter7

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

const val THREAD_POOL_SIZE = 3

val executor: ExecutorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE)

class ShortUser(val id: Int)
class User(val id: Int, val avatar: String)

fun loadListOfFriends(callback: (List<ShortUser>) -> Unit) {
    executor.submit {
        Thread.sleep(3000)
        callback(listOf(ShortUser(0), ShortUser(1)))
    }
}

fun loadUserDetails(id: Int, callback: (User) -> Unit) {
    executor.submit {
        Thread.sleep(3000)
        callback(User(id, "avatar"))
    }
}

fun loadImage(avatar: String, callback: (Image) -> Unit) {
    executor.submit {
        Thread.sleep(3000)
        callback(Image())
    }
}

fun main(args: Array<String>) {
    loadListOfFriends {users ->
        loadUserDetails(users.first().id) {user ->
            loadImage(user.avatar) {image ->
                showImage(image)
            }
        }
    }
}

fun showImage(image: Image) {
    //........
}