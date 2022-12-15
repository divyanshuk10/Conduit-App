package com.divyanshu.api.models.services

import com.divyanshu.api.models.response.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ConduitAPI {

  @GET("articles")
  fun getArticles(): Call<ArticlesResponse>
}