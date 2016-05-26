package com.example.fashkl.project.DataWareHouse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.fashkl.project.DataWareHouse.DatabaseSchma.BookingTable;
import com.example.fashkl.project.DataWareHouse.DatabaseSchma.RegesterationTable;


/**
 * Created by fashkl on 13/05/16.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DataBaseName="regester.db";
    public DataBaseHelper(Context context) {
        super(context,DataBaseName, null, VERSION);
    }

    public static int C2I(String s){
        return Integer.parseInt(s);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String RegisterCreateTable=
                "create table " + RegesterationTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                RegesterationTable.Cols.UUID + " integer unique, " +
                RegesterationTable.Cols.NAME+" not null, "+
                RegesterationTable.Cols.PASSWORD+" not null, "+
                RegesterationTable.Cols.ADDRESS+" not null, "+
                RegesterationTable.Cols.AGE+" not null, "+
                RegesterationTable.Cols.MOBILENO+" integer unique not null, "+
                RegesterationTable.Cols.CARDNO+" integer unique not null"+
                ");";

        String CREATE_BOOKING_TABLE =
                "CREATE TABLE " + BookingTable.NAME + "( " +
                        " _id integer primary key autoincrement, " +
                        BookingTable.Cols.ticketId + " INTEGER unique, " +
                        BookingTable.Cols.lineType + " TEXT, " +
                        BookingTable.Cols.fromStation + " TEXT, " +
                        BookingTable.Cols.toStation + " TEXT, " +
                        BookingTable.Cols.ticketCost + " INTEGER, " +
                        BookingTable.Cols.journyType + " TEXT, " +
                        BookingTable.Cols.total + " INTEGER, " +
                        BookingTable.Cols.balance + " INTEGER, " +
                        BookingTable.Cols.date + " TEXT " +
                        " );";

        db.execSQL(RegisterCreateTable);
        db.execSQL(CREATE_BOOKING_TABLE);
        Log.v(DataBaseHelper.class.getSimpleName(),"DataBase Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

