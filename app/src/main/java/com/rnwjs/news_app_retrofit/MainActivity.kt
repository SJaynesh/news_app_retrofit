package com.rnwjs.news_app_retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.rnwjs.news_app_retrofit.adapter.NewsAdapter
import com.rnwjs.news_app_retrofit.databinding.ActivityMainBinding
import com.rnwjs.news_app_retrofit.models.NewsModel
import com.rnwjs.news_app_retrofit.services.api.APIClient.Companion.getClient
import com.rnwjs.news_app_retrofit.services.api.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchNewsData()


    }

    private fun fetchNewsData() {
        val apiInterface = getClient()!!.create(APIInterface::class.java)

        apiInterface.getNews().enqueue(object  : Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {

                val model = response.body()
                Log.i("Success", "onResponse: ${model!!.articles?.get(0)!!.title}")

                if(model!=null)
                {
                    if(model.articles!=null) {
                        val adapter = NewsAdapter(model.articles)

                        binding.rvNews.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.e("Error", "onFailure: $t", )
            }
        })
    }

}