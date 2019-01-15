package com.sunnat629.clientside.model

import com.google.gson.annotations.SerializedName

data class Comment (
    @SerializedName("id") var comment: Long?,
    @SerializedName("text") var text: String?,
    @SerializedName("postedBy") var profile: Profile?,
    @SerializedName("commentCreatedTime") var commentCreatedTime: String?
    )