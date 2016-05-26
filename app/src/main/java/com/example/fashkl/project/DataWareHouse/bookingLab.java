package com.example.fashkl.project.DataWareHouse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.fashkl.project.DataWareHouse.DatabaseSchma.BookingTable;

import static com.example.fashkl.project.DataWareHouse.DataBaseHelper.C2I;

/**
 * Created by fashkl on 15/05/16.
 */
public class bookingLab {
    public static bookingLab lab;
    private BookingTicket bookingTicket;
    private SQLiteDatabase mDatabase;
    public static boolean flage = false;

    private bookingLab(Context context) {
        bookingTicket = new BookingTicket();
        mDatabase = new DataBaseHelper(context).getWritableDatabase();
    }

    public static bookingLab get(Context context) {
        if (lab == null) {
            lab = new bookingLab(context);
        }
        return lab;
    }



    public Boolean insert(BookingTicket bookingTicket) {
        ContentValues values = getContentValues(bookingTicket);
        long n = mDatabase.insert(DatabaseSchma.BookingTable.NAME, null, values);
        Log.v("Suc Inserted ROW # : ", "" + n);
        if (n > -1) {
            return true;
        } else {
            return false;
        }
    }

    public ContentValues getContentValues(BookingTicket bookingTicket) {
        ContentValues values = new ContentValues();
        values.put(DatabaseSchma.BookingTable.Cols.ticketId, bookingTicket.getTicketId());
        values.put(DatabaseSchma.BookingTable.Cols.lineType, bookingTicket.getLineType());
        values.put(DatabaseSchma.BookingTable.Cols.fromStation, bookingTicket.getFromStation());
        values.put(DatabaseSchma.BookingTable.Cols.toStation, bookingTicket.getToStation());
        values.put(DatabaseSchma.BookingTable.Cols.ticketCost, bookingTicket.getCost());
        values.put(DatabaseSchma.BookingTable.Cols.journyType, bookingTicket.getJournyType());
        values.put(DatabaseSchma.BookingTable.Cols.total, bookingTicket.getTotal());
        values.put(DatabaseSchma.BookingTable.Cols.balance, bookingTicket.getBalance());
        values.put(DatabaseSchma.BookingTable.Cols.date, bookingTicket.getDate());
        return values;
    }

    public boolean getflag(){
        return flage;
    }
    public TicketDetails findTicket(int ticketId) {
        Cursor cursor = mDatabase.query(
                BookingTable.NAME,
                null,
                BookingTable.Cols.ticketId + " = ? ",
                new String[]{String.valueOf(ticketId)},
                null, null, null);
        Log.v("TagTag", "[[[[[[[[[[Cursor is not null and it's okkkkkkkkkkkkkkkkk]]]]]]]]]]]]");
        if (cursor != null) {
            cursor.moveToFirst();
            try {
                return new TicketDetails(
                        C2I(cursor.getString(cursor.getColumnIndex(BookingTable.Cols.ticketId))),
                        cursor.getString(cursor.getColumnIndex(BookingTable.Cols.toStation)),
                        cursor.getString(cursor.getColumnIndex(BookingTable.Cols.fromStation)),
                        cursor.getString(cursor.getColumnIndex(BookingTable.Cols.journyType)),
                        cursor.getString(cursor.getColumnIndex(BookingTable.Cols.date)));
            } catch (Exception ex) {
                flage = true;
            }
        } else {
            return null;
        }
        return null;
    }

    public void deletTicket(int ticketId) {

        int n = mDatabase.delete(BookingTable.NAME, BookingTable.Cols.ticketId + "= ?", new String[]{String.valueOf(ticketId)});
        mDatabase.close();
        if (n > -1) {
//            Toast.makeText(bookingLab.this, "dsds", Toast.LENGTH_SHORT).show();
            Log.v("T", "# deleted Rows :: " + n);
        } else {
            Log.v("T2", "No deleted Rows");
        }
    }


}
