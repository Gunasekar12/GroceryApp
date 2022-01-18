package com.example.groceryapp.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.groceryapp.model.Record1


@Dao
public  interface Grocerydao {

    @Insert
    fun insert(model: ArrayList<Record1>?) {
    }

@Query("SELECT * FROM  Gerocery ORDER BY state ASC")
 fun getalldatas():LiveData<ArrayList<Record1>>

}