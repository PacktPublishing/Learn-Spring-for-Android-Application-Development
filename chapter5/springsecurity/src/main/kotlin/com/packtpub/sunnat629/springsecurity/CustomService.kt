package com.packtpub.sunnat629.springsecurity

import org.springframework.security.access.annotation.Secured

@Secured
class CustomService{
    @Secured
    fun secure(): String{
        return "The is Secured..."
    }
}