package com.packtpub.sunnat629.testing_application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestingApplication

fun main(args: Array<String>) {
	runApplication<TestingApplication>(*args)
}

