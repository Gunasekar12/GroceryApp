package com.example.groceryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Spinner
import com.example.groceryapp.model.Root
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterActivity : AppCompatActivity() {
    var stateslist:ArrayList<String>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val submit = findViewById<Button>(R.id.save)

        getapidata();
    }

    private fun getapidata() {

        val destination: Destinationservice =
                ServiceBuilder.buildservice(Destinationservice::class.java)
        val response: Call<Root> = destination.getallgrocerydatas(
                resources.getString(R.string.api_key),
                resources.getString(R.string.format),
                0,
                10
        )

        response.enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {

                val getgroceryresponse: Root = response.body()!!;



//                if (getgroceryresponse.getRecords().size > 0)
//                {
////                    for(i int)
////                    {
////
////                    }
//
//                    for (i in 0..getgroceryresponse.getRecords().size-1)
//                        {
//
//                        Log.d("Getrec","datas "+getgroceryresponse.getRecords().get(i).getDistrict());
//                        }



            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.d("retrofit100failuer ", "datas " + t.message);
            }

        })

    }
}