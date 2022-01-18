package com.example.groceryapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.groceryapp.model.Record1;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface groceryDao {

    @Query("Select * from groceryRecords")
    List<Record1> getAllRecords();

    @Insert
    void insertRecord(Record1 record1);

    @Query("Delete from groceryRecords")
    void deleteRecord();
}
