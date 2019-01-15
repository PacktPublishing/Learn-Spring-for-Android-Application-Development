package com.sunnat629.clientside.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.sunnat629.clientside.basicauth.BasicAuthInterceptor


class UserServiceImpl{
   fun getUserServiceImplImpl(username:String, password:String): UserService {
        val retrofit = Retrofit.Builder()
                .client(getOkhttpClient(username, password))
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(UserService::class.java)
    }

    private fun getOkhttpClient(username:String, password:String): OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(BasicAuthInterceptor(username, password))
                .build()
    }
}