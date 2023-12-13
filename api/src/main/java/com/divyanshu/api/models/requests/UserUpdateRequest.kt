package com.divyanshu.api.models.requests

import com.divyanshu.api.models.entity.UserUpdateData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
  @Json(name = "user")
  val user: UserUpdateData
)
