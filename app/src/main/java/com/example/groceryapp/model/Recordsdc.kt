package com.example.groceryapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(tableName = "Grocery")
data class Recordsdc(
        @PrimaryKey(autoGenerate = true)
        val id:Int=0,
        @ColumnInfo(name ="state")
        val state:String,
        @ColumnInfo(name="disctrict")
        val disctrict:String,
        @ColumnInfo(name="market")
        val market:String,
        @ColumnInfo(name="commodity")
        val commodity:String,
        @ColumnInfo(name="variety")
        val variety:String,
        @ColumnInfo(name="arrival_date")
        val arrival_date:String,
        @ColumnInfo(name = "min_price")
        val min_price:String,
        @ColumnInfo(name="max_price")
        val max_price:String,
        @ColumnInfo(name = "model_price")
        val model_price:String)


