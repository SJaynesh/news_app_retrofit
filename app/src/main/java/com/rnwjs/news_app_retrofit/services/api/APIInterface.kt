package com.rnwjs.news_app_retrofit.services.api

import com.rnwjs.news_app_retrofit.models.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIInterface {

    // ?q=tesla&from=2025-01-04&sortBy=publishedAt&apiKey=e390be9c3aa8420fa9d4ea20770a4b30

    @GET("everything")
    fun getNews(
        @Query("q") q: String,
        @Query("from") from: String = "2025-01-04",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "e390be9c3aa8420fa9d4ea20770a4b30"
    ): Call<NewsModel>
}

// POJO  == POKO

// POJO => Plain Object Java Object
// POKO => Plain Object Kotlin Object