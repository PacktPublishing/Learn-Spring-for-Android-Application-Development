package com.sunnat629.mvvmroomexample.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.sunnat629.mvvmroomexample.model.Users
import com.sunnat629.mvvmroomexample.repository.dao.UserDAO

class UsersRepository(private val mUserDAO: UserDAO) {

    val mAllUsers: LiveData<List<Users>> = mUserDAO.getAllUsers()

    /** @WorkerThread annotation is using to mark that this function needs to be called from
     * a non-UI thread
     *
     * suspend modifier to tell the compiler that this function need to be called from a
     * coroutine or another suspended function
     *
     * */
    @WorkerThread
    suspend fun insert(user: Users){
        mUserDAO.addNewUser(user)
    }
}