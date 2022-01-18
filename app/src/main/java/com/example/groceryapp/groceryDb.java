package com.example.groceryapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.groceryapp.model.Record1;

@Database(entities = Record1.class, version = 12)
public abstract class groceryDb extends RoomDatabase {
    private static groceryDb groceryDatabase = null;
    private static final String databaseName = "groceryRecords";

    public abstract groceryDao groceryDao();

    public static synchronized groceryDb getGroceryDatabase(Context context)
    {
        if(groceryDatabase == null)
            groceryDatabase = Room.databaseBuilder(context.getApplicationContext(),groceryDb.class,databaseName).
                    allowMainThreadQueries().build();

        return groceryDatabase;
    }


}
