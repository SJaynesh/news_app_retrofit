package com.rnwjs.news_app_retrofit.services.api

import com.rnwjs.news_app_retrofit.models.NewsModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("everything?q=sport&from=2025-01-03&sortBy=publishedAt&apiKey=e390be9c3aa8420fa9d4ea20770a4b30")
    fun getNews():Call<NewsModel>

}

// POJO  == POKO

// POJO => Plain Object Java Object
// POKO => Plain Object Kotlin Object