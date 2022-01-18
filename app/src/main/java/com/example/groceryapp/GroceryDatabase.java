package com.example.groceryapp;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.groceryapp.Room.GroceryDao1;
import com.example.groceryapp.model.Recordsdc;

@Database(entities = Recordsdc.class,version = 1)
public abstract class    GroceryDatabase extends RoomDatabase {


 /*   private static GroceryDatabase instance;

    public abstract GroceryDao1 getallrecords();

    public static synchronized GroceryDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),GroceryDatabase.class,"Grocery_database")
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }


    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback()
    {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

//    private static class populatedbasynctask extends AsyncTask<Void,Void,Void> {
//        private GroceryDao1 groceryDao1;
//
//
//      private   populatedbasynctask(GroceryDatabase db) {
//            groceryDao1 =db.getallrecords();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            return null;
//        }
//    }*/
}
