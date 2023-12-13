package com.divyanshu.newapp.data

import android.util.Log
import com.divyanshu.api.ConduitClient
import com.divyanshu.api.models.entity.Article

object ArticlesRepo {

  val api = ConduitClient.publicAPI
  val authApi = ConduitClient.authAPI

  suspend fun fetchGlobalFeed() = api.getArticles().body()?.articles

  suspend fun fetchMyFeed(): List<Article>? {
    Log.d("ArticlesRepo", "fetchMyFeed: ${ConduitClient.authToken}")
    return authApi.getFeedArticles().body()?.articles
  }

}