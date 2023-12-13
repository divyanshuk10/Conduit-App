package com.divyanshu.api.models.requests

import com.divyanshu.api.models.entity.LoginData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
  @Json(name = "user")
  val user: LoginData
)
