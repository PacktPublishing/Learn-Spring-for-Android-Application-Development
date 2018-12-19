package com.packtpub.sunnat629.jpa_db_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class JpaDbTestApplication

fun main(args: Array<String>) {
    runApplication<JpaDbTestApplication>(*args)
}
