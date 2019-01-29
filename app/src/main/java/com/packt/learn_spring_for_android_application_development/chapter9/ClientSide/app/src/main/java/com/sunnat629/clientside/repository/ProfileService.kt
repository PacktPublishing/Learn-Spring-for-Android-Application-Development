package com.sunnat629.clientside.repository

import com.sunnat629.clientside.model.Profile
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface ProfileService {

//    POST http://localhost:8080/profile/new
//    GET http://localhost:8080/profiles
//    GET http://localhost:8080/profile/{id}
//    PUT http://localhost:8080/profile/{id}
//    DELETE http://localhost:8080/profile/{id}

    // New Profile registration
    @Headers("Content-Type: application/json")
    @POST("/profile/new")
    fun registerProfile(@Body profile: Profile): Observable<Profile>

    @Headers("Content-Type: application/json")
    @GET("/profile/login")
    fun loginProfile(@Query("username") username: String, @Query("password") password: String): Observable<Profile>

   // Get Profile by ID
    @GET("/profile/{userId}")
    fun getUserById(@Path("userId") userId: Long): Observable<Profile>

}