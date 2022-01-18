//package com.example.groceryapp.Room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//
//
//@Database(entities = [ GroceryModel::class], version = 1)
//
//public abstract  class Grocerydb: RoomDatabase() {
//
//    abstract fun GroceryDao(): Grocerydao?
// public var Grocerydatabase:Grocerydb?=null
//val context: Context?=null
//
//    @Synchronized
//  public  fun GroceryDatabase(ctx:Context): Grocerydb?
//    {
//        if(Grocerydatabase!= null) {
//            Grocerydatabase= Room.databaseBuilder(ctx.applicationContext,Grocerydb::class.java,"grocery_db")
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//
//
//
//        return Grocerydatabase
//
//    }
//
//}