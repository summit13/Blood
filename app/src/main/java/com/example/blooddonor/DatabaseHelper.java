package com.example.blooddonor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String dbname = "blood_donor_db.db";

    public DatabaseHelper(Context context)
    {
        //create database and table
        super(context, dbname, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //cretaing user info table
        String user_info = "CREATE TABLE \"user_info\" (\n" +
                "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"address\"\tTEXT NOT NULL,\n" +
                "\t\"dob\"\tTEXT NOT NULL,\n" +
                "\t\"phone\"\tTEXT NOT NULL,\n" +
                "\t\"email\"\tTEXT NOT NULL,\n" +
                "\t\"password\"\tTEXT NOT NULL,\n" +
                "\t\"blood_group\"\tTEXT NOT NULL\n" +
                ")";

        db.execSQL(user_info);

        //creating events table
        String events = "CREATE TABLE \"events\" (\n" +
                "\t\"eventID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"eventTitle\"\tTEXT NOT NULL,\n" +
                "\t\"eventDescription\"\tTEXT NOT NULL,\n" +
                "\t\"eventDate\"\tTEXT NOT NULL,\n" +
                "\t\"eventTime\"\tTEXT NOT NULL\n" +
                ")";

        db.execSQL(events);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user_info");
        db.execSQL("DROP TABLE IF EXISTS blood_inventory");
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);

    }

    public boolean addUser(String name, String address, String dob, String phone, String email, String password, String blood_group)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("dob",dob);
        cv.put("phone",phone);
        cv.put("email",email);
        cv.put("password",password);
        cv.put("blood_group",blood_group);

        //insert function returns -1 if the process is failed
        long result = db.insert("user_info", null,cv);
        //table name, factory, content values

        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean checkEmail(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_info WHERE email=?", new String[]{email});
        if (cursor.getCount()>0)
            return false;
        else
            return true;
    }

    public boolean addEvent(String eventTitle, String eventDescription, String eventDate, String eventTime)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("eventTitle",eventTitle);
        cv.put("eventDescription",eventDescription);
        cv.put("eventDate",eventDate);
        cv.put("eventTime",eventTime);

        long result = db.insert("events",null,cv);

        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean login(String email, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_info WHERE email=? AND password=?", new String[]{email, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor viewAllUsers()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM user_info";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor viewAllEvents()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM events";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

}
