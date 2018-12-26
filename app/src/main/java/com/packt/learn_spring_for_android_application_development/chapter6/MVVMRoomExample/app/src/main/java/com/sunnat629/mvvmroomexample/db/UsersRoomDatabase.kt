package com.sunnat629.mvvmroomexample.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.sunnat629.mvvmroomexample.model.Users
import com.sunnat629.mvvmroomexample.repository.dao.UserDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Users::class], version = 1)
abstract class UsersRoomDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO

    // static members
    companion object {
        @Volatile
        private var INSTANCE: UsersRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UsersRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsersRoomDatabase::class.java,
                    "user_database"
                ).addCallback(UserDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.userDAO())
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        fun populateDatabase(userDao: UserDAO) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
//            userDao.deleteAllUsers()

            userDao.addNewUser(
                Users(
                    "Sunnat", "sunnat629@gmail.com",
                    "1234567890", "Dhaka"
                )
            )
            userDao.addNewUser(
                Users(
                    "Chaity", "chaity123@gmail.com",
                    "54321987", "Dhaka"
                )
            )
        }
    }
}
