package com.example.bank_registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class userDetails extends SQLiteOpenHelper {

    private final static String tableName = "userDetails";
    private final static String username = "username";
    private final static String password = "password";
    private final static String phoneNumber = "phoneNumber";

    public userDetails(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+tableName+"("+username+" VARCHAR PRIMARY KEY, "+password+" VARCHAR, "+phoneNumber+"VARCHAR )";
        db.execSQL(createTable);
        Log.d("Database", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(db);
    }

    public int getCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);

        int count = 0;
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            count  = count + 1;
            cursor.moveToNext();
        }

        return count;
    }

}
