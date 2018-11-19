package springforandroid.pactpub.sunnat629.resttemptest

import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.*


interface GithubInterface {
    @GET("users/{user}/")
    fun listRepos(@Path("user") user: String): Call<List<Users>>

    @POST("user/repos")
    fun createRepo(@Body repo:Repository, @Header("Authorization") accessToken: String,
                   @Header("Accept") apiVersionSpec: String,
                   @Header("Content-Type") contentType: String): Call<Repository>

    @PUT("gists/{id}")
    fun updateGist(@Path("id") id: String, @Body gist: Gist): Call<ResponseBody>

    @DELETE("repos/{owner}/{repo}")
    fun deleteRepo(@Header("Authorization") accessToken: String,
                   @Header("Accept") apiVersionSpec: String,
                   @Path("repo") repo: String,
                   @Path("owner") owner: String): Call<DeleteRepos>


    @Headers("Accept: application/vnd.github.v3.full+json", "User-Agent: Spring for Android")
    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<Users>
}