package com.packtpub.sunnat629.jpa_db_test.jpa_db_test.dao

import com.packtpub.sunnat629.jpa_db_test.jpa_db_test.model.UserModel

interface UserDAOInterface {

    // to get all the users details
    fun getAllUsers(): List<UserModel>

    // to get one specific user details
    fun getUser(int: Int): UserModel

    // to add a user
    fun addUser(userModel: UserModel): UserModel

    // to update a user
    fun updateUser(userModel: UserModel): UserModel

    // to delete a user
    fun deleteUser(int: Int)
}