package com.packtpub.sunnat629.ssoauth2.ssoauth2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController{

//    This is for all means there is no security issue for this URL path
    @GetMapping(value = ["/", ""])
    fun home(): String{
        return "Welcome Home"
    }

    //    Yu have to use token to get this URL path
    @GetMapping("/private")
    fun securedArea(): String{
        return "Welcome to Secured Area"
    }
}