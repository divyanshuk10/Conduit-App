package com.divyanshu.api.models.response


import com.divyanshu.api.models.entity.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
  @Json(name = "user")
  val user: User
)