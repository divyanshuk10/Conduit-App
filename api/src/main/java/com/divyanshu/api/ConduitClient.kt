package com.divyanshu.api

import com.divyanshu.api.services.ConduitAPI
import com.divyanshu.api.services.ConduitAuthAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object ConduitClient {

  var authToken: String? = null

  private val authInterceptor = Interceptor { chain ->
    var request = chain.request()
    authToken?.let {
      request = request.newBuilder()
        .header("Authorization", "Token $authToken")
        .build()
    }
    chain.proceed(request)
  }

  private val moshi =
    Moshi.Builder()
      .addLast(KotlinJsonAdapterFactory())
      .build()

  var okHttpClientAuth = OkHttpClient.Builder()
    .readTimeout(5, TimeUnit.SECONDS)
    .connectTimeout(2, TimeUnit.SECONDS)
    .addInterceptor(authInterceptor)

  var okHttpClientPublic = OkHttpClient.Builder()
    .readTimeout(5, TimeUnit.SECONDS)
    .connectTimeout(2, TimeUnit.SECONDS)
    .followSslRedirects(true)
    .followRedirects(true)

  val retrofit = Retrofit.Builder()
    .baseUrl("https://api.realworld.io/api/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))

  val publicAPI = retrofit.client(okHttpClientPublic.build()).build().create(ConduitAPI::class.java)

  val authAPI = retrofit.client(okHttpClientAuth.build()).build().create(ConduitAuthAPI::class.java)


}