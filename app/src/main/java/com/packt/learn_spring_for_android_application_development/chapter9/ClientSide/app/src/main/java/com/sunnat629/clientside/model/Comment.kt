package com.sunnat629.clientside.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Comment (
    @SerializedName("id") var comment: Long?,
    @SerializedName("text") var text: String?,
    @SerializedName("postedBy") var profile: Profile?,
    @SerializedName("commentCreatedTime") var commentCreatedTime: Date?
    )
{
    override fun toString(): String {
        return "Comment(comment=$comment, text=$text, profile=$profile, commentCreatedTime=$commentCreatedTime)"
    }
}