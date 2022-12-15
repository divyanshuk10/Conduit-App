package com.divyanshu.api.models.response


import com.divyanshu.api.models.entity.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentResponse(
  @Json(name = "comment")
  val comments: Comment
)