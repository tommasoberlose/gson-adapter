package com.tommasoberlose.gsonadapter

import android.util.Log
import com.google.gson.*

import java.net.HttpURLConnection
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import java.lang.reflect.Type
import com.google.gson.annotations.SerializedName




/**
 * Created by tommaso on 23/08/17.
 */

class NetworkAdapter {
  val apiService: APIService

  init {
    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()


    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.128:8080/v1/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    apiService = retrofit.create(APIService::class.java)
  }
}
