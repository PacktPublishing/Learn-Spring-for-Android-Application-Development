package springforandroid.pactpub.sunnat629.retrofitinkotlintest.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import springforandroid.pactpub.sunnat629.retrofitinkotlintest.model.GitHubUserModel

interface GithubService {
    @GET("/users/{user}/repos")
    fun reposOfUser(@Path("user") user: String): Call<List<GitHubUserModel>>
}