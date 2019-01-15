package com.sunnat629.clientside.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id") var postId: Long?,
    @SerializedName("text") var text: String?,
    @SerializedName("postedBy") var profile: Profile?,
    @SerializedName("postCreatedTime") var postCreatedTime: String?,
    @SerializedName("comments") var comment: ArrayList<Comment>?,
    @SerializedName("likes") var likes: ArrayList<Like>?
)