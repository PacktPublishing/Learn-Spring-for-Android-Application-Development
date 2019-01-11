package com.packtpub.sunnat629.social_network

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
class SocialNetworkApplication

fun main(args: Array<String>) {
	runApplication<SocialNetworkApplication>(*args)
}

