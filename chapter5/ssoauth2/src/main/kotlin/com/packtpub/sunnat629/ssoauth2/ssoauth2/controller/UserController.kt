package com.packtpub.sunnat629.ssoauth2.ssoauth2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController{

//    This is for all means there is no security issue for this URL path
    @GetMapping(value = ["/", "","/open_for_all"])
    fun home(): String{
        return "This area can be accessed by all."
    }

    //    Yu have to use token to get this URL path
    @GetMapping("/private")
    fun securedArea(): String{
        return "You used an access token to enter this area."
    }
}