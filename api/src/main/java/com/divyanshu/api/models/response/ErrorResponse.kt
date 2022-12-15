package com.divyanshu.api.models.response



import com.divyanshu.api.models.entity.Errors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
  @Json(name = "errors")
  val errors: Errors
)