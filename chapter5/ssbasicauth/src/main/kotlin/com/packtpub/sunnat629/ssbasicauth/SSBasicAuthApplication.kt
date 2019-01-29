package com.packtpub.sunnat629.ssbasicauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class SSBasicAuthApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<SSBasicAuthApplication>(*args)
}
