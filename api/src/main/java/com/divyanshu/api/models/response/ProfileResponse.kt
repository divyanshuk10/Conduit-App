package com.divyanshu.api.models.response


import com.divyanshu.api.models.entity.Profile
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileResponse(
  @Json(name = "profile")
  val profile: Profile
)