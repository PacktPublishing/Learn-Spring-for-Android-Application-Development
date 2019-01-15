package com.sunnat629.clientside.repository

import com.sunnat629.clientside.model.Profile
import retrofit2.Call
import retrofit2.http.GET
import com.sunnat629.clientside.model.UserModel
import io.reactivex.Observable

interface UserService {
    @GET("/users")
    fun getUserList(): Observable<List<UserModel>>
}