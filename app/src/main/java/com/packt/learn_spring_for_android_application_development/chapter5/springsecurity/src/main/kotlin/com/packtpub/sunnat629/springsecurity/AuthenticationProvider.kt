package com.packtpub.sunnat629.springsecurity

import org.springframework.security.core.Authentication
import javax.security.sasl.AuthenticationException

interface AuthenticationProvider {
    @Throws(AuthenticationException::class)
    fun authenticate(authentication: Authentication):Authentication

    fun supports(authentication: Class<*>): Boolean
}