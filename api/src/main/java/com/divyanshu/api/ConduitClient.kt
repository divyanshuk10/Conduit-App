package com.divyanshu.api

import com.divyanshu.api.services.ConduitAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ConduitClient {

  private val moshi =
    Moshi.Builder()
      .addLast(KotlinJsonAdapterFactory())
      .build()

  var okHttpClient = OkHttpClient.Builder()
    .addInterceptor(RedirectInterceptor())
    .followSslRedirects(true)
    .followRedirects(true)
    .build()

  val retrofit = Retrofit.Builder()
    .baseUrl("https://conduit.productionready.io/api/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClient)
    .build()

  val api = retrofit.create(ConduitAPI::class.java)


}