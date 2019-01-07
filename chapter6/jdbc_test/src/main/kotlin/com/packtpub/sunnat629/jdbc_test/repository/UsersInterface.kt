package com.packtpub.sunnat629.jdbc_test.repository

import com.packtpub.sunnat629.jdbc_test.UserModel

interface UsersInterface {
    fun getAllUserList(): List<UserModel>
    fun getUserByID(id: Int): UserModel?
    fun addNewUser(userModel: UserModel)
    fun updateUser(userModel: UserModel, id: Int)
    fun deleteUser(id: Int)
}


