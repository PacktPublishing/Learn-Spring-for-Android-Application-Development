package com.packtpub.sunnat629.ssoauth2test.ssoauth2test.service

import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.model.User

interface UserService {

    fun save(user: User): User
    fun findAll(): List<User>
    fun findOne(id: Long): User
    fun delete(id: Long)
}
