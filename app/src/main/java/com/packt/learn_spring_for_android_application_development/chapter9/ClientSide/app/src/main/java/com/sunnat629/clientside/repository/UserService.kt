package com.sunnat629.clientside.repository

import retrofit2.Call
import retrofit2.http.GET
import com.sunnat629.clientside.model.UserModel

interface UserService {
    @GET("/users")
    fun getUserList(): Call<List<UserModel>>
}