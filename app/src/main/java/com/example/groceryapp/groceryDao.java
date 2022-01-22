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

    @Query("Select * from groceryRecords where state = :stateToMatch")
    List<Record1> getParticularState(String stateToMatch);

    @Query("Select * from groceryRecords where district = :districtToMatch")
    List<Record1> getParticularDistrict(String districtToMatch);

    @Insert
    void insertRecord(Record1 record1);

    @Query("Delete from groceryRecords")
    void deleteRecord();
}
