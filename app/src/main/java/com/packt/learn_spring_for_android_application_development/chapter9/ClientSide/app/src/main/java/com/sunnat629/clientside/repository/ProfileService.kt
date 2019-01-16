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

    // Get All Profiles
    @Headers("Content-Type: application/json")
    @GET("/profiles")
    fun getUserList(): Observable<List<Profile>>

   // Get Profile by ID
    @GET("/profile/{userId}")
    fun getUserById(@Path("userId") userId: Long): Observable<Profile>

    //     Update Profile by ID
    @PUT("/profile/{userId}")
    fun updateUserById(@Query("userId") userId: Long, @Body mUser: Profile): Observable<Profile>

    // Delete Profile by ID
    @DELETE("/profile/{userId}")
    fun deleteUserById(@Query("userId") userId: Long): Any
}