package com.example.fashkl.project.DataWareHouse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;
import com.example.fashkl.project.DataWareHouse.DatabaseSchma.RegesterationTable;

import static com.example.fashkl.project.DataWareHouse.DataBaseHelper.C2I;


/**
 * Created by fashkl on 13/05/16.
 */

public class RegisteratoinLab {
    public static RegisteratoinLab lab;
    private Registeration registeration;
    private SQLiteDatabase mDatabase;
    private Context mContext;
    public static boolean flage = false;

    private RegisteratoinLab(Context context) {
        registeration = new Registeration();
        mDatabase = new DataBaseHelper(context).getWritableDatabase();
    }

    public static RegisteratoinLab get(Context context) {
        if (lab == null) {
            lab = new RegisteratoinLab(context);
        }
        return lab;
    }

    public Boolean insert(Registeration registeration) {
        long n = -1;
        try {
            ContentValues values = getContentValues(registeration);
            n = mDatabase.insert(RegesterationTable.NAME, null, values);
            Log.v("Suc Inserted ROW # : ", "" + n);
        } catch (SQLiteConstraintException ex1) {
//            Log.v("Tag","ID is already used ");
            Toast.makeText(mContext, "ID is already used", Toast.LENGTH_SHORT).show();
        }
        if (n > -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int id, double balance) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RegesterationTable.Cols.CARDNO, balance);

        long c = mDatabase.update(RegesterationTable.NAME, contentValues,
                RegesterationTable.Cols.UUID + " = ? ", new String[]{String.valueOf(id)});
        if (c > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getId(int uuid) {
        UserDetails userDetails = findUserDetails(uuid);
        return userDetails.getUserID();
    }

    public double getBalance(int uuid) {
        UserDetails userDetails = findUserDetails(uuid);
        return userDetails.getBalance();
    }

    public boolean getflage() {
        return flage;
    }

    public UserDetails findUserDetails(int userId) {

        Cursor cursor = mDatabase.query(
                RegesterationTable.NAME,
                null,
                RegesterationTable.Cols.UUID + "=?",
                new String[]{String.valueOf(userId)},
                null, null, null
        );
        if (cursor != null) {
            cursor.moveToFirst();
            Log.v("Tag1", "CURSOR IS FULL");
            try {

                return new UserDetails(
                        C2I(cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.UUID))),  // userId
                        cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.PASSWORD)),  // paswrod
                        cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.NAME)),       // name
                        cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.ADDRESS)),       // address
                        C2I(cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.AGE))),  // age
                        C2I(cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.MOBILENO))),  // mobileNo
                        C2I(cursor.getString(cursor.getColumnIndex(RegesterationTable.Cols.CARDNO)))    // balance
                );
            } catch (Exception e) {
                flage = true;
            }
        } else {
            Log.v("Tagg", "CURSOR EMPTY");
            return null;
        }

        return null;
    }

//    public void updateBalance(int id, double value) {
//        ContentValues values = new ContentValues();
//        values.put(RegesterationTable.Cols.CARDNO, );
//    }

    public ContentValues getContentValues(Registeration registeration) {
        ContentValues values = new ContentValues();
        values.put(RegesterationTable.Cols.UUID, registeration.getUuid());
        values.put(RegesterationTable.Cols.NAME, registeration.getUserName());
        values.put(RegesterationTable.Cols.PASSWORD, registeration.getPassword());
        values.put(RegesterationTable.Cols.ADDRESS, registeration.getAddress());
        values.put(RegesterationTable.Cols.AGE, registeration.getAge());
        values.put(RegesterationTable.Cols.MOBILENO, registeration.getMobileNo());
        values.put(RegesterationTable.Cols.CARDNO, registeration.getCardNo());
        return values;
    }


}
