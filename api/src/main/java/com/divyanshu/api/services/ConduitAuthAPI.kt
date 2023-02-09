package com.divyanshu.api.services

import com.divyanshu.api.models.requests.UserUpdateRequest
import com.divyanshu.api.models.response.ArticlesResponse
import com.divyanshu.api.models.response.ProfileResponse
import com.divyanshu.api.models.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthAPI {

  @GET
  suspend fun getCurrentUser(): Response<UserResponse>

  @PUT("user")
  suspend fun updateCurrentUser(@Body userUpdateRequest: UserUpdateRequest): Response<UserResponse>

  @GET("profiles/{username}")
  suspend fun getProfile(@Path("username") username: String): Response<ProfileResponse>

  @POST("profiles/{username}/follow")
  suspend fun followProfile(@Path("username") username: String): Response<ProfileResponse>

  @DELETE("profiles/{username}/follow")
  suspend fun unFollowProfile(@Path("username") username: String): Response<ProfileResponse>

  @GET("articles/feed")
  suspend fun getFeedArticles(): Response<ArticlesResponse>

  @POST("articles/{slug}/favorite")
  suspend fun favoriteArticle(
    @Path("slug") slug: String
  ): Response<ArticlesResponse>

  @POST("articles/{slug}/favorite")
  suspend fun unFavoriteArticle(
    @Path("slug") slug: String
  ): Response<ArticlesResponse>

}