package springforandroid.pactpub.sunnat629.basicauthinkotlin.repository

import retrofit2.Call
import retrofit2.http.GET
import springforandroid.pactpub.sunnat629.basicauthinkotlin.model.UserModel

interface UserService {
    @GET("/users")
    fun getUserList(): Call<List<UserModel>>
}