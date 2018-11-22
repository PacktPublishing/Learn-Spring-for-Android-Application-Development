package com.packtpub.sunnat629.ssoauth2test.ssoauth2test.dao


import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : CrudRepository<User, Long> {
    fun findByUserName(userName: String): User
}
