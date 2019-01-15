package com.sunnat629.clientside.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id") var userID: String?,
    @SerializedName("username") var username: String?,
    @SerializedName("password") var password: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("accCreatedTime") var accCreatedTime: String?,
    @SerializedName("firstName") var firstName: String?,
    @SerializedName("lastName") var lastName: String?,
    @SerializedName("contactNumber") var contactNumber: String?,
    @SerializedName("country") var country: String?
    )