package com.packtpub.sunnat629.springsecurity

import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication


interface AccessDecisionManager {
    fun supports(attribute: ConfigAttribute): Boolean

    fun supports(clazz: Class<*>): Boolean

//    fun vote(authentication: Authentication, object: S,
//             attributes: Collection<ConfigAttribute>): Int
}