package com.example.groceryapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.Adapters.FieldlistAdapter
import com.example.groceryapp.Room.GroceryDao1
import com.example.groceryapp.Room.Grocerydao
import com.example.groceryapp.model.Record1
import com.example.groceryapp.model.Root
import com.example.groceryapp.model.getgroceryresponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    var fieldadapter:FieldlistAdapter?=null
    var fieldrec:RecyclerView?=null
    var groceryList: List<Record1> ?= null
    var filteredRecords : ArrayList<Record1> ?= null
    var grocerydao: groceryDao ?= null
    val grocerygetlist: ArrayList<Record1> =ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fieldrec=findViewById(R.id.fieldrecy)

        if (checkForInternet(this)) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            fetchdatafromserver()

        } else {
            fetchdatafromRoom()

            if(groceryList!!.isNotEmpty())
            {
                setadapter(groceryList!! as ArrayList<Record1>)
                fieldadapter!!.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this, "Check the NetworkConnection. No data Found" , Toast.LENGTH_SHORT).show()
            }
        }

        val intent = intent // = intent
        filteredRecords = intent.getSerializableExtra("filteredRecords") as ArrayList<Record1>?

        if(filteredRecords != null) {

            // filtering the data
            setadapter(filteredRecords!!)
            fieldadapter!!.notifyDataSetChanged()
        }

    }

    private fun fetchdatafromRoom(){
        // Retrieving values from ROOM DB
        grocerydao = groceryDb.getGroceryDatabase(applicationContext).groceryDao()
        groceryList = grocerydao!!.allRecords
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

                if (getgroceryresponse != null)
                {
                    if(filteredRecords != null)
                    {
                        setadapter(filteredRecords!!)
                        fieldadapter!!.notifyDataSetChanged()
                    }
                    else
                    setadapter(getgroceryresponse.getRecords())
                }

                if (getgroceryresponse != null) {
                    grocerygetlist!!.addAll(getgroceryresponse.getRecords())
                }

                // inserting value into Room DB
                grocerydao = groceryDb.getGroceryDatabase(applicationContext).groceryDao()
                grocerydao!!.deleteRecord()

                for(i in grocerygetlist!!.iterator())
                {
                    grocerydao!!.insertRecord(i)
                }
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.d("retrofit100failure ", "datas " + t.message)
            }
        })
    }

    private fun setadapter(getgroceryresponse: ArrayList<Record1>) {
        fieldadapter=FieldlistAdapter(getgroceryresponse)
        fieldrec!!.layoutManager=LinearLayoutManager(this)
        fieldrec!!.adapter=fieldadapter

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

    // creating menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // filter option
        if(item.itemId == R.id.filter)
        {
            val intent = Intent(applicationContext,FiltersRecords::class.java)
            if (checkForInternet(this)){
                intent.putExtra("filterdatas", grocerygetlist)
            }
            else
            {
                fetchdatafromRoom()
                intent.putExtra("filterdatas", groceryList as ArrayList<Record1>)
            }

            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}