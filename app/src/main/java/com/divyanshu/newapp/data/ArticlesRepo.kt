package com.divyanshu.newapp.data

import com.divyanshu.api.ConduitClient

object ArticlesRepo {

  val api = ConduitClient().api

  suspend fun fetchGlobalFeed() = api.getArticles()

}