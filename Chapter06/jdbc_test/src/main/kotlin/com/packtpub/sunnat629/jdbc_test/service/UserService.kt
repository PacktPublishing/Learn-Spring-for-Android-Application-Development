package com.packtpub.sunnat629.jdbc_test.service

import com.packtpub.sunnat629.jdbc_test.UserModel
import com.packtpub.sunnat629.jdbc_test.repository.UserRepository
import com.packtpub.sunnat629.jdbc_test.repository.UsersInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService: UsersInterface {
    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getAllUserList(): List<UserModel> {
        return userRepository.getAllUserList()
    }

    override fun getUserByID(id: Int): UserModel? {
        return userRepository.getUserByID(id)
    }

    override fun addNewUser(userModel: UserModel) {
        userRepository.addNewUser(userModel)
    }

    override fun updateUser(userModel: UserModel, id: Int) {
        userRepository.updateUser(userModel, id)
    }

    override fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }
}