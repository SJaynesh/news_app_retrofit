package com.rnwjs.news_app_retrofit

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.rnwjs.news_app_retrofit.databinding.ActivityMainBinding
import com.rnwjs.news_app_retrofit.models.NewsModel
import com.rnwjs.news_app_retrofit.services.api.APIClient
import com.rnwjs.news_app_retrofit.services.api.APIClient.Companion.getClient
import com.rnwjs.news_app_retrofit.services.api.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
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
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.e("Error", "onFailure: $t", )
            }
        })
    }

}