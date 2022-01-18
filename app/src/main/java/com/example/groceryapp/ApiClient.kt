package com.example.groceryapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    val baseUrl="https://api.data.gov.in/resource/"
//    fun getInstance(): Retrofit
//    {
//        return Retrofit.Builder().baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

    var gson = GsonBuilder()
            .setLenient()
            .create()

    private val okhttp=OkHttpClient.Builder();
    private val builder=Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okhttp.build())
    private val retrofit= builder.build();

    fun <T> buildservice(getgroceryresponse: Class<T>):
            T {
return  retrofit.create(getgroceryresponse)
    }

}