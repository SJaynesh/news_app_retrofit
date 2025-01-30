package com.rnwjs.news_app_retrofit.services.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

  companion object {
      var retrofit: Retrofit? = null
      val BASE_URL = "https://newsapi.org/v2/"

      fun getClient(): Retrofit? {
          retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
              .build()

          return retrofit
      }
  }
}