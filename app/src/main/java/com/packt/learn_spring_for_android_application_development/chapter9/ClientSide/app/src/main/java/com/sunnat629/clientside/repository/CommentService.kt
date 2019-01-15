package com.sunnat629.clientside.repository

import com.sunnat629.clientside.model.Post
import io.reactivex.Observable
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

interface CommentService {

//    POST http://localhost:8080/comment/{user_id}/{post_id}
//    DELETE http://localhost:8080/comment/{id}


    // Post comment in a post by Profile ID and Post ID
    @POST("/comment/{user_id}/{post_id}")
    fun postCommentByPostId(@Query("post_id") postId: Long, @Query("user_id") userId: Long,
                            @Field("") commentText: String): Observable<Post>

    // delete comment List of a status
    @DELETE("/comment/{id}")
    fun deleteCommentByPostId(@Field("id") id: Long): Any
}