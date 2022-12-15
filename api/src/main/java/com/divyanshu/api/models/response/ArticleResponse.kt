package com.divyanshu.api.models.response


import com.divyanshu.api.models.entity.Article
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleResponse(
  @Json(name = "article")
  val article: Article
)