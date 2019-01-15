package com.sunnat629.clientside.model

import com.google.gson.annotations.SerializedName

data class Like (
    @SerializedName("id") var comment: Long?,
    @SerializedName("postedBy") var profile: Profile?
)