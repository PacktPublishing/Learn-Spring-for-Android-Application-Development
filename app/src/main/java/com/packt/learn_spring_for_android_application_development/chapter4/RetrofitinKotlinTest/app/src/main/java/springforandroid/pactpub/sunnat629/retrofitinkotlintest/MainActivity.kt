package springforandroid.pactpub.sunnat629.retrofitinkotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import springforandroid.pactpub.sunnat629.retrofitinkotlintest.model.GitHubUserModel
import springforandroid.pactpub.sunnat629.retrofitinkotlintest.repository.GithubService
import springforandroid.pactpub.sunnat629.retrofitinkotlintest.repository.GithubServiceImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val githubService: GithubService = GithubServiceImpl().getGithubServiceImpl()

        val call: Call<List<GitHubUserModel>> = githubService.reposOfUser("sunnat629")
        call.enqueue(object: Callback<List<GitHubUserModel>>{
            override fun onFailure(call: Call<List<GitHubUserModel>>, t: Throwable) {
                Log.wtf("PACKTPUB", t.message)
            }

            override fun onResponse(call: Call<List<GitHubUserModel>>, response: Response<List<GitHubUserModel>>) {
                val listItems = arrayOfNulls<String>( response.body()!!.size)
                for (i in 0 until response.body()!!.size) {
                    val recipe = response.body()!![i]
                    listItems[i] = recipe.name
                }
                val adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, listItems)
                displayList.adapter = adapter
            }
        })
    }
}
