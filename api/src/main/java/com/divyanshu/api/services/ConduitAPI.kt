package com.divyanshu.api.services

import com.divyanshu.api.models.requests.SignupRequest
import com.divyanshu.api.models.response.ArticlesResponse
import com.divyanshu.api.models.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitAPI {

  @POST("users")
  suspend fun signupUser(@Body signupRequest: SignupRequest): Response<UserResponse>

  @GET("articles")
  suspend fun getArticles(
    @Query("author") author: String? = null,
    @Query("favourited") favourites: String? = null,
    @Query("tag") tag: String? = null,
  ): Response<ArticlesResponse>
}