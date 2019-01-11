package com.sunnat629.mvvmroomexample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.sunnat629.mvvmroomexample.db.UsersRoomDatabase
import com.sunnat629.mvvmroomexample.model.Users
import com.sunnat629.mvvmroomexample.repository.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

open class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository: UsersRepository
    private val mAllUsers: LiveData<List<Users>>

    private var  parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    init {
        val userDao = UsersRoomDatabase.getDatabase(application, scope).userDAO()
        mRepository = UsersRepository(userDao)
        mAllUsers = mRepository.mAllUsers
    }

    fun getAllUsers(): LiveData<List<Users>>{
        return mAllUsers
    }

    fun insert(users: Users) = scope.launch(Dispatchers.IO){
        mRepository.insert(users)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}