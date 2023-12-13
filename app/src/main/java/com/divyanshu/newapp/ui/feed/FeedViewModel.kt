package com.divyanshu.newapp.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyanshu.api.models.entity.Article
import com.divyanshu.newapp.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
  private val TAG = this::class.java.simpleName
  private val _feeds = MutableLiveData<List<Article>>()
  val feeds: LiveData<List<Article>> = _feeds

  fun fetchGlobalFeed() {
    viewModelScope.launch {
      ArticlesRepo.fetchGlobalFeed()?.let {
        _feeds.postValue(it)
      }
    }
  }

  fun fetchMyFeed() {
    viewModelScope.launch {
      ArticlesRepo.fetchMyFeed()?.let {
        _feeds.postValue(it)
      }
    }
  }

}