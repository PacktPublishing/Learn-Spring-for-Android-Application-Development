package com.sunnat629.clientside.repository

import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.model.Profile
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface PostService {

//    POST http://localhost:8080/post/{id}/new
//    GET http://localhost:8080/posts
//    GET http://localhost:8080/post/{id}
//    PUT http://localhost:8080/post/{id}
//    DELETE http://localhost:8080/post/{id}

    // Submit a post
    @Headers("Content-Type: application/json")
    @POST("/post/{profile_id}/new")
    fun submitNewPost(@Path("profile_id") id: Long, @Query("text") text: String): Observable<List<Post>>


    // Get all posted status
    @Headers("Content-Type: application/json")
    @GET("/posts")
    fun getPostList(): Single<List<Post>>


    // Get all posted status by Profile ID
    @Headers("Content-Type: application/json")
    @GET("/post/{id}")
    fun getPostById(@Path("id") id: Long): Observable<Post>
}