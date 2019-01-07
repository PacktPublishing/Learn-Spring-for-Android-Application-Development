package com.packtpub.sunnat629.socialmedia

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class SocialMediaApplication

fun main(args: Array<String>) {
	runApplication<SocialMediaApplication>(*args)
}