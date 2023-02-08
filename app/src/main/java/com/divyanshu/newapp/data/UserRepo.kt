package com.divyanshu.newapp.data

import com.divyanshu.api.ConduitClient
import com.divyanshu.api.models.entity.LoginData
import com.divyanshu.api.models.entity.SignupData
import com.divyanshu.api.models.entity.User
import com.divyanshu.api.models.requests.LoginRequest
import com.divyanshu.api.models.requests.SignupRequest

object UserRepo {

  val api = ConduitClient.publicAPI
  val authApi = ConduitClient.authAPI

  suspend fun login(email: String, password: String): User? {
    val response = api.loginUser(LoginRequest(LoginData(email, password)))
    // TODO : save it in shared prefs
    ConduitClient.authToken = response.body()?.user?.token
    return response.body()?.user
  }

  suspend fun getUserProfile() {
    val response = authApi.getCurrentUser().body()?.user
  }

  suspend fun signup(username: String, email: String, password: String): User? {
    val response = api.signupUser(SignupRequest(SignupData(email, password, username)))
    // TODO : save it in shared prefs
    ConduitClient.authToken = response.body()?.user?.token
    return response.body()?.user
  }

}