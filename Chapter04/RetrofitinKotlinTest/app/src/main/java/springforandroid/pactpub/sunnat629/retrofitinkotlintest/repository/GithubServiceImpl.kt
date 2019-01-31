package springforandroid.pactpub.sunnat629.retrofitinkotlintest.repository

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GithubServiceImpl{
   fun getGithubServiceImpl(): GithubService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(GithubService::class.java)
    }
}