package com.packtpub.sunnat629.jdbc_test.jdbc_test.service

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.UserModel
import com.packtpub.sunnat629.jdbc_test.jdbc_test.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService: UserServiceInterface {
    @Autowired
    private val userRepository: UserRepository?= null

    override fun getAllUserList(): List<UserModel> {
       return userRepository!!.getAllUserDetails()
    }
}