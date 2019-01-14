//package com.packtpub.sunnat629.social_network.service
//
//import com.packtpub.sunnat629.social_network.repository.UserByNameRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.AuthenticationException
//import org.springframework.stereotype.Service
//
//
//@Service
//class CustomAuthenticationProvider: AuthenticationProvider {
//
//    @Autowired
//    private var userByNameRepository: UserByNameRepository? = null
//
//    @Throws(AuthenticationException::class)
//    override fun authenticate(authentication: Authentication?): Authentication? {
//        val username = authentication!!.name
//        val password = authentication.credentials.toString()
//
//        val isUsernamePasswordWork = userByNameRepository!!.getUserByNamePassword(username, password)
//        if (isUsernamePasswordWork){
//            return UsernamePasswordAuthenticationToken(username,password)
//        }
//        return null
//    }
//
//    override fun supports(authentication: Class<*>?): Boolean {
//        return authentication!! == UsernamePasswordAuthenticationToken::class.java
//    }
//}