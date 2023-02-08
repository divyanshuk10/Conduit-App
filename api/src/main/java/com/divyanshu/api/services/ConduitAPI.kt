package com.divyanshu.api.services

import com.divyanshu.api.models.requests.LoginRequest
import com.divyanshu.api.models.requests.SignupRequest
import com.divyanshu.api.models.response.ArticlesResponse
import com.divyanshu.api.models.response.TagsResponse
import com.divyanshu.api.models.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

  @POST("users")
  suspend fun signupUser(@Body signupRequest: SignupRequest): Response<UserResponse>

  @POST("users/login")
  suspend fun loginUser(@Body loginRequest: LoginRequest): Response<UserResponse>

  @GET("articles")
  suspend fun getArticles(
    @Query("author") author: String? = null,
    @Query("favourited") favourites: String? = null,
    @Query("tag") tag: String? = null,
  ): Response<ArticlesResponse>

  @GET("articles/{slug}")
  suspend fun getArticleBySlug(
    @Path("slug") slug: String
  ): Response<ArticlesResponse>

  @GET("tags")
  suspend fun getTags(): Response<TagsResponse>


}