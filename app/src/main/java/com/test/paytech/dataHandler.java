package com.test.paytech;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "PayTechDB";

    public dataHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE ResourceDetails"+
                      "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                      "fName TEXT,"+"lName TEXT,"+"DOB TEXT,"+"Email TEXT,"+"Contact INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS ResourceDetails";
        db.execSQL(query);
        onCreate(db);

    }
}
