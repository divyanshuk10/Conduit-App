package com.divyanshu.newapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyanshu.api.ConduitClient
import com.divyanshu.api.models.entity.User
import com.divyanshu.newapp.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
  val api = ConduitClient.publicAPI
  private val _user = MutableLiveData<User>()
  val user: LiveData<User> = _user

  fun login(email: String, password: String) = viewModelScope.launch {
    UserRepo.login(email, password)?.let {
      _user.postValue(it)
    }
  }

  fun signup(username: String, email: String, password: String) = viewModelScope.launch {
    UserRepo.signup(username, email, password)?.let {
      _user.postValue(it)
    }
  }

}