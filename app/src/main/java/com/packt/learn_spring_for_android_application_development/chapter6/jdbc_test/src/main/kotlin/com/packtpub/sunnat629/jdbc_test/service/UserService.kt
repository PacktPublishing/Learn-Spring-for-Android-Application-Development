package com.packtpub.sunnat629.jdbc_test.service

import com.packtpub.sunnat629.jdbc_test.UserModel
import com.packtpub.sunnat629.jdbc_test.repository.UserDao
import com.packtpub.sunnat629.jdbc_test.repository.UsersInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService: UsersInterface {
    @Autowired
    private lateinit var userDao: UserDao

    override fun getAllUserList(): List<UserModel> {
        return userDao.getAllUserList()
    }

    override fun getUserByID(id: Int): UserModel? {
        return userDao.getUserByID(id)
    }

    override fun addNewUser(userModel: UserModel) {
        userDao.addNewUser(userModel)
    }

    override fun updateUser(userModel: UserModel, id: Int) {
        userDao.updateUser(userModel, id)
    }

    override fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }
}