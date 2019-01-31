package com.sunnat629.mvvmroomexample.repository.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sunnat629.mvvmroomexample.model.Users

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewUser(users: Users)

    @Query("DELETE FROM USERS")
    fun deleteAllUsers()

    @Query("SELECT * FROM USERS ORDER BY username ASC")
    fun getAllUsers():  LiveData<List<Users>>
}
