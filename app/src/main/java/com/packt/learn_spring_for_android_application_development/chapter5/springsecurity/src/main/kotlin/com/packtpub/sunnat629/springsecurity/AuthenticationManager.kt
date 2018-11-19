package com.packtpub.sunnat629.springsecurity

import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException

/**
 * a sample code of AuthenticationManager interface which is used for authentication process
 * */

interface AuthenticationManager {
    @Throws(AuthenticationException::class)
    fun authenticate(authentication: Authentication): Authentication
}