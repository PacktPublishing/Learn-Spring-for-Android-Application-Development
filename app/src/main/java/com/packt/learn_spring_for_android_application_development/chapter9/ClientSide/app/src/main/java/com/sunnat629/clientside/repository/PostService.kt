package com.sunnat629.clientside.repository

import com.sunnat629.clientside.model.Post
import com.sunnat629.clientside.model.Profile
import io.reactivex.Observable
import retrofit2.http.*

interface PostService {

//    POST http://localhost:8080/post/{id}/new
//    GET http://localhost:8080/posts
//    GET http://localhost:8080/post/{id}
//    PUT http://localhost:8080/post/{id}
//    DELETE http://localhost:8080/post/{id}

    // Submit a post
    @Headers("Content-Type: application/json")
    @POST("/post/{id}/new")
    fun submitNewPost(@Query("id") id: Long, @Field("text") text: String): Observable<Post>


    // Get all posted status
    @Headers("Content-Type: application/json")
    @GET("/posts")
    fun getPostList(): Observable<List<Post>>


    // Get all posted status by Profile ID
    @Headers("Content-Type: application/json")
    @GET("/post/{id}")
    fun getPostById(
        @Query("id") id: Long
    ): Observable<Post>


    // Update all posted status by Profile ID
    @Headers("Content-Type: application/json")
    @PUT("/post/{profile_id}")
    fun updatePostById(
        @Query("profile_id") id: Long,
        @Field("text") text: String
    ): Observable<Post>


    // Delete a posted status by Profile ID
    @Headers("Content-Type: application/json")
    @DELETE("/post/{id}")
    fun deletePostByUserId(@Query("id") id: Long): Any
}