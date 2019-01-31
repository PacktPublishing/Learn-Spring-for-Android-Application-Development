package springforandroid.pactpub.sunnat629.resttemptest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // These code for RestTemplate

        val baseUrl: String? = "YOUR_URL"
        val restTemplate = RestTemplate()
        val uri = URI(baseUrl)
        val body = "The Body"

        /** GET **/
        val responseGet = restTemplate.getForEntity(baseUrl, String::class.java)

        val responseURIGet = restTemplate.getForEntity(uri, String::class.java)


        /** POST **/
        val responsePost = restTemplate.postForEntity(baseUrl, body, String::class.java)

        val requestPost = HttpEntity(body)
        val responseExchangePost = restTemplate.exchange(baseUrl, HttpMethod.POST, requestPost, String::class.java)

        val responseURIPost = restTemplate.postForEntity(uri, body, String::class.java)
        val responseExchangeURIPost = restTemplate.exchange(uri, HttpMethod.POST, requestPost, String::class.java)

        /** PUT **/
        restTemplate.put(baseUrl, body)
        restTemplate.put(uri, body)

        /** DELETE **/
        restTemplate.delete(baseUrl)
        restTemplate.delete(uri)

        /** OPTIONS **/
        val allowHeadersURI = restTemplate.optionsForAllow(uri)
    }
}
