package com.divyanshu.newapp.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyanshu.api.ConduitClient
import com.divyanshu.api.models.entity.Article
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

  val authAPI = ConduitClient.publicAPI
  private var _article = MutableLiveData<Article>()
  val article: LiveData<Article> = _article

  fun fetchArticle(slug: String) = viewModelScope.launch {
    val response = authAPI.getArticleBySlug(slug)
    response.body()?.article?.let {
      _article.postValue(it)
    }
  }
}