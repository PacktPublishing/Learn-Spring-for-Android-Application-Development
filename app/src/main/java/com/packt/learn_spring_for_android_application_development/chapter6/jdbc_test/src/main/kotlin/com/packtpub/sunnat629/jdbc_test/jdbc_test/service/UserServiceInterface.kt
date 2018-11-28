package com.packtpub.sunnat629.jdbc_test.jdbc_test.service

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.UserModel

interface UserServiceInterface{
    fun getAllUserList(): List<UserModel>
}