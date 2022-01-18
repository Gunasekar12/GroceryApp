package com.example.groceryapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapp.Adapters.FieldlistAdapter
import com.example.groceryapp.model.Record1
import com.example.groceryapp.model.Root

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var fieldadapter:FieldlistAdapter?=null
    var fieldrec:ListView?=null
    var groceryList: List<Record1> ?= null

    var stateRecords : ArrayList<String> ?= null
    var districtRecords : ArrayList<String> ?= null
    var filteredRecords : ArrayList<Record1> ?= null
    val tempStateList : ArrayList<Record1>?=null
    var grocerydao: groceryDao ?= null


    val grocerygetlist:ArrayList<Record1>?=ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fieldrec=findViewById(R.id.fieldrecy)

        if (checkForInternet(this)) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            fetchdatafromserver()

        } else {

            grocerydao = groceryDb.getGroceryDatabase(applicationContext).groceryDao()
            groceryList = grocerydao!!.getAllRecords()
               if(groceryList != null && groceryList!!.size > 0) {
                   setadapter(grocerygetlist!! as ArrayList<Record1>)
               }
               else
                Toast.makeText(this, "Check the NetworkConnection. No data Found" , Toast.LENGTH_SHORT).show()
        }

        val // = intent
        stateRecords = intent.getStringArrayListExtra("stateRecords")
        districtRecords = intent.getStringArrayListExtra("districtRecords")

        filteredRecords = intent.getSerializableExtra("filteredRecords") as ArrayList<Record1>?


        if(filteredRecords != null && filteredRecords!!.size > 0)
        {
//            for (i in filteredRecords!!.iterator()) {
//                System.out.println("filtered_Record :" + i.min_price)
//            }

            if(groceryList!!.size > 0)
                grocerygetlist!!.clear()
            else{
                setadapter(filteredRecords!!)
            }
            //Toast.makeText(this, "Date_Size " + filteredRecords!!.size, Toast.LENGTH_SHORT).show()
        }

      /*  if(stateRecords != null)
        {

            Toast.makeText(this, "Date_Size " + grocerygetlist!!.size, Toast.LENGTH_SHORT).show()

            for(i in stateRecords!!.iterator())
            {
                //filteredRecords!!.add(grocerygetlist!!.get(index))
                    tempStateList!!.add(grocerygetlist!!.get(0))
            }

            Toast.makeText(this, "temp_list_size" + tempStateList!!.size, Toast.LENGTH_SHORT).show()

         //   fieldrec!!.adapter = FieldlistAdapter(this, filteredRecords)
        }

        if(districtRecords != null)
        {
            //  Toast.makeText(this, stateRecords!!.size, Toast.LENGTH_SHORT).show()
            for(i in districtRecords!!.iterator())
            {
                //filteredRecords!!.add(grocerygetlist!!.get(index))
                Toast.makeText(this, i, Toast.LENGTH_SHORT).show()

            }


            //   fieldrec!!.adapter = FieldlistAdapter(this, filteredRecords)
        }*/

    }

    private fun fetchdatafromserver() {
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

                val getgroceryresponse: Root?  = response.body()!!

                setadapter(getgroceryresponse!!.getRecords())

                grocerygetlist!!.addAll(getgroceryresponse.getRecords())

                // inserting value into Room DB
                grocerydao = groceryDb.getGroceryDatabase(applicationContext).groceryDao()

                grocerydao!!.deleteRecord()

                for(i in grocerygetlist.iterator())
                {
                    grocerydao!!.insertRecord(i)
                }

                // Retrieving values from ROOM DB
                 groceryList = grocerydao!!.getAllRecords()

                Log.i("room_Db", "data: " + grocerygetlist!!.size)

            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.d("retrofit100failuer ", "datas " + t.message)
            }

        })

    }

    private fun setadapter(getgroceryresponse: ArrayList<Record1>) {

   //     fieldadapter=FieldlistAdapter(getgroceryresponse.getRecords())
   //     fieldrec!!.layoutManager=LinearLayoutManager(this)
   //      fieldrec!!.adapter

        val adapter = FieldlistAdapter(this,getgroceryresponse)
        fieldrec!!.adapter = adapter
    }

    @SuppressLint("MissingPermission")
    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")

            return networkInfo.isConnected
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // filter option
        if(item.itemId == R.id.filter)
        {
            val intent = Intent(applicationContext,FiltersRecords::class.java)
            intent.putExtra("filterdatas", grocerygetlist)
            startActivity(intent)
        }


        return super.onOptionsItemSelected(item)
    }

}