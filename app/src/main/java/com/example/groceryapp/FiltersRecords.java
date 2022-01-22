package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.groceryapp.model.Record1;

import java.io.Serializable;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Collections;

public class FiltersRecords extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<String> stateslist = new ArrayList<>();
    private ArrayList<String> districtslist = new ArrayList<>();
    private String userSelectedState, userSelectedDistrict;
    private Spinner spinner, spinnerdis;
    private Button submit;
    private ArrayList<Record1> listsdatas;
    private static String Sel_state,Sel_dis;
    private ArrayList<ArrayList<Record1>> filtersave= new ArrayList<ArrayList<Record1>>();
    private RadioButton min_max, max_min, dateComparator;
    private groceryDao groceryDaoObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters_records);
        submit = findViewById(R.id.save);
        spinner = findViewById(R.id.spinner);
        spinnerdis = findViewById(R.id.spinnerdistrict);
        min_max = findViewById(R.id.radioButton2);
        max_min = findViewById(R.id.radioButton3);
        dateComparator = findViewById(R.id.radioButton4);

        listsdatas = (ArrayList<Record1>) getIntent().getSerializableExtra("filterdatas");

        if (listsdatas != null) {
            setstatedata();
            setdistrictdata();
        }

        spinner.setOnItemSelectedListener(this);

        spinnerdis.setOnItemSelectedListener(this);

        groceryDaoObj = groceryDb.getGroceryDatabase(this).groceryDao();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(min_max.isChecked())
                {
                    Collections.sort(listsdatas, Record1.MIN);
                }
                else if(max_min.isChecked())
                {
                    Collections.sort(listsdatas, Record1.MAX);
                }
                else if(dateComparator.isChecked())
                {
                    Collections.sort(listsdatas, Record1.dateComparison);
                }

                // Toast.makeText(getApplicationContext(),"size " + Sel_state + " " + Sel_dis ,Toast.LENGTH_SHORT).show();

                if(!TextUtils.isEmpty(Sel_state))
                {
                    listsdatas = (ArrayList<Record1>) groceryDaoObj.getParticularState(Sel_state);
                }
                if(!TextUtils.isEmpty(Sel_dis))
                {
                    listsdatas = (ArrayList<Record1>) groceryDaoObj.getParticularDistrict(Sel_dis);
                    Log.i("District", "lists_District :" + Sel_dis);
                }

                for(int i = 0; i < listsdatas.size(); i++)
                {
                    Log.i("District", "lists_District :" + listsdatas.get(i).getDistrict());

                }

                Intent intent = new Intent(FiltersRecords.this, MainActivity.class);
                intent.putExtra("filteredRecords",new ArrayList<Record1>(listsdatas));

                startActivity(intent);
            }
        });
    }

    private void setdistrictdata() {

        for (int i = 0; i < listsdatas.size(); i++) {
            districtslist.add(listsdatas.get(i).getDistrict());
        }

        ArrayAdapter ad1
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                districtslist);

        ad1.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spinnerdis.setAdapter(ad1);

    }

    private void setstatedata() {

        for (int i = 0; i < listsdatas.size(); i++) {
            stateslist.add(listsdatas.get(i).getState());
        }
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                stateslist);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spinner.setAdapter(ad);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

        if(adapterView.getId()==R.id.spinner)
        {
            Sel_state = listsdatas.get(pos).getState();
         }
        else if(adapterView.getId()==R.id.spinnerdistrict)
        {
            Sel_dis=listsdatas.get(pos).getDistrict();
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please Select any one option!", Toast.LENGTH_SHORT).show();
    }
}