package com.divyanshu.api.models.requests

import com.divyanshu.api.models.entity.SignupData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignupRequest(
  @Json(name = "user")
  val user: SignupData
)