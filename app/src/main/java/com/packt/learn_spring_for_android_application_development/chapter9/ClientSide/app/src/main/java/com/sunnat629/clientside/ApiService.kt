//package com.sunnat629.clientside.adapter
//
//import com.sunnat629.clientside.ApiWorker
//import com.sunnat629.clientside.Constants
//import com.sunnat629.clientside.repository.ProfileService
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//
//object ApiService {
//    fun profileAPICall() = Retrofit.Builder()
//        .baseUrl(Constants.API_BASE_PATH)
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .addConverterFactory(ApiWorker.gsonConverter)
//        .client(ApiWorker.client)
//        .build()
//        .create(ProfileService::class.java)
//}