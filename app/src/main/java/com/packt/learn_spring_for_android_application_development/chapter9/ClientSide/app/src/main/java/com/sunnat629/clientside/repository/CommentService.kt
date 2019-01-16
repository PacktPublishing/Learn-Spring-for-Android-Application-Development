package com.sunnat629.clientside.repository

import com.sunnat629.clientside.model.Post
import io.reactivex.Observable
import retrofit2.http.*

interface CommentService {

//    POST http://localhost:8080/comment/{user_id}/{post_id}
//    DELETE http://localhost:8080/comment/{id}


    // Post comment in a post by Profile ID and Post ID
    @POST("/comment/{user_id}/{post_id}")
    fun postCommentByPostId(@Path("post_id") postId: Long, @Path("user_id") userId: Long,
                            @Query("commentText") commentText: String): Observable<Post>

    // delete comment List of a status
    @DELETE("/comment/{id}")
    fun deleteCommentByPostId(@Field("id") id: Long): Any
}