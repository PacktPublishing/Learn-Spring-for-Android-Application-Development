package com.packtpub.sunnat629.jpa_db_test.jpa_db_test.dao

import com.packtpub.sunnat629.jpa_db_test.jpa_db_test.model.UserModel
import org.springframework.stereotype.Repository
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager;


class UserDAO: UserDAOInterface {

    @PersistenceContext
    val entryManager: EntityManager ?= null

    override fun getAllUsers(): List<UserModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(int: Int): UserModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addUser(userModel: UserModel): UserModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUser(userModel: UserModel): UserModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(int: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}