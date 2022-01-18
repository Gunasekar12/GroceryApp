package com.example.groceryapp

import com.example.groceryapp.model.Root
import com.example.groceryapp.model.getgroceryresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Destinationservice {

    @GET("9ef84268-d588-465a-a308-a864a43d0070?")
    fun getallgrocerydatas(@Query("api-key")  name:String, @Query("format") fileformat:String, @Query("offset") offset:Int, @Query("limit") limit:Int)
            : Call<Root>
}