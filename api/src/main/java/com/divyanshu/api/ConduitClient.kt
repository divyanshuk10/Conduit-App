package com.divyanshu.api

import com.divyanshu.api.models.services.ConduitAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ConduitClient {

  private val moshi =
    Moshi.Builder()
      .addLast(KotlinJsonAdapterFactory())
      .build()

  val retrofit = Retrofit.Builder()
    .baseUrl("https://conduit.productionready.io/api/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

  val api = retrofit.create(ConduitAPI::class.java)
}