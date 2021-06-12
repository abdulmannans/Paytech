package com.test.paytech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class tableControl extends dataHandler{
    public tableControl(Context context) {
        super(context);
    }
    public boolean create(objectResource objectResource){
        ContentValues values = new ContentValues();

        values.put("fName", objectResource.fName);
        values.put("lName", objectResource.lName);
        values.put("DOB", objectResource.DOB);
        values.put("Email", objectResource.Email);
        values.put("Contact", objectResource.Contact);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("ResourceDetails",null,values) > 0;

        db.close();
        return createSuccessful;
    }

    public List<objectResource>readEmpName(){

        List<objectResource> EmpRecords = new ArrayList<objectResource>();

        String query = "SELECT fName, lName FROM ResourceDetails ORDER BY fName";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do {
                String fName = cursor.getString(cursor.getColumnIndex("fName"));
                String lName = cursor.getString(cursor.getColumnIndex("lName"));

                objectResource objectResource = new objectResource();
                objectResource.fName = fName;
                objectResource.lName = lName;

                EmpRecords.add(objectResource);
            }while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return EmpRecords;
    }

    public List<objectResource>readResource(String fName){

        List<objectResource> Resource = new ArrayList<objectResource>();

        SQLiteDatabase db =this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM ResourceDetails WHERE fName ='"+fName+"'",null);
        String fN, lN, DOB, Em, Phn;

        if (cursor.moveToFirst()){
            fN = cursor.getString(cursor.getColumnIndex("fName"));
            lN = cursor.getString(cursor.getColumnIndex("lName"));
            DOB = cursor.getString(cursor.getColumnIndex("DOB"));
            Em = cursor.getString(cursor.getColumnIndex("Email"));
            Phn = cursor.getString(cursor.getColumnIndex("Contact"));

            objectResource objectResource = new objectResource();
            objectResource.fName = fN;
            objectResource.lName = lN;
            objectResource.DOB = DOB;
            objectResource.Email = Em;
            objectResource.Contact = Phn;
            Resource.add(objectResource);

        }






        cursor.close();
        db.close();

        return Resource;


    }
}
