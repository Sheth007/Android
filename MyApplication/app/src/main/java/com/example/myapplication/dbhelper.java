package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(@Nullable Context context)
    {
        super(context, "mydatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(Id Integer, Name String)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertData(String Id, String Name)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ID",Id);
        cv.put("Name",Name);
        db.insert("student",null,cv);
    }
    public Cursor displaydata()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM student",null);
        return c;
    }

    public void updatedata(String Id, String Name)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Id",Id);
        cv.put("Name",Name);
        db.update("student",cv,"Id=?",new String[]{Id});
    }

    public void deletedata(String ID)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete("student","id=?",new String[]{ID});
    }
}
