package com.example.groceryapp.model;

import android.content.Intent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


@Entity (tableName = "groceryRecords")
public class Record1  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "state")
    String state;

    @ColumnInfo(name = "district")
    String district;

    @ColumnInfo(name = "market")
    String market;

    @ColumnInfo(name = "commodity")
    String commodity;

    @ColumnInfo(name = "variety")
    String variety;

    @ColumnInfo(name = "arrival_date")
    String arrival_date;

    @ColumnInfo(name = "min_price")
    String min_price;

    @ColumnInfo(name = "max_price")
    String max_price;

    @ColumnInfo(name = "modal_price")
    String modal_price;

    public static final Comparator<Record1> dateComparison = new Comparator<Record1>() {
        @Override
        public int compare(Record1 o1, Record1 o2) {
            return o1.getArrival_date().compareTo(o2.getArrival_date());
        }
    };

    public static final Comparator<Record1> stateComparison = new Comparator<Record1>() {
        @Override
        public int compare(Record1 o1, Record1 o2) {
            return o1.getState().compareTo(o2.getState());
        }
    };

    public static final Comparator<Record1> districtComparison = new Comparator<Record1>() {
        @Override
        public int compare(Record1 o1, Record1 o2) {
            return o1.getDistrict().compareTo(o2.getDistrict());
        }
    };


    public static final Comparator<Record1> MIN = new Comparator<Record1>() {
        @Override
        public int compare(Record1 o1, Record1 o2) {
            Integer firstPrice = Integer.parseInt(o1.getMin_price());
            Integer secondPrice = Integer.parseInt(o2.getMin_price());
            return firstPrice - secondPrice;
        }
    };

    public static final Comparator<Record1> MAX = new Comparator<Record1>() {
        @Override
        public int compare(Record1 o1, Record1 o2) {
            Integer firstPrice = Integer.parseInt(o1.getMax_price());
            Integer secondPrice = Integer.parseInt(o2.getMax_price());
            return secondPrice - firstPrice;
        }
    };

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getModal_price() {
        return modal_price;
    }

    public void setModal_price(String modal_price) {
        this.modal_price = modal_price;
    }



}



