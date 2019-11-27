package com.example.blooddonor;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;

public class connectivity extends SQLiteOpenHelper
{
    private static String dbname = "blood_donor_db.db";

    //CONSTRUCTOR
    public connectivity(Context context)
    {
        super(context, dbname, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //admin_table
        String admin_info = "CREATE TABLE admin_info (adminID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL)";

        db.execSQL(admin_info);

        //blood_inventory table
        String blood_inventory = "CREATE TABLE \"blood_inventory\" (\n" +
                "\t\"blood_group\"\tINTEGER NOT NULL,\n" +
                "\t\"quantity\"\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY(\"blood_group\")\n" +
                ")";

        db.execSQL(blood_inventory);

        //user info table
        String user_info = "CREATE TABLE \"user_info\" (\n" +
                "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"address\"\tTEXT NOT NULL,\n" +
                "\t\"dob\"\tTEXT NOT NULL,\n" +
                "\t\"phone\"\tTEXT NOT NULL,\n" +
                "\t\"username\"\tTEXT NOT NULL,\n" +
                "\t\"password\"\tTEXT NOT NULL,\n" +
                "\t\"blood_group\"\tTEXT NOT NULL\n" +
                ")";

        db.execSQL(user_info);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
//        db.execSQL("DROP TABLE IF EXISTS admin_info");
//        db.execSQL("DROP TABLE IF EXISTS user_info");
//        db.execSQL("DROP TABLE IF EXISTS blood_inventory");
        onCreate(db);
    }

    public String addUser(String name, String address, String dob, String phone, String username, String password, String blood_group)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("dob",dob);
        cv.put("phone",phone);
        cv.put("username",username);
        cv.put("password",password);
        cv.put("blood_group",blood_group);

        long res = db.insert("user_info", null,cv);
        //table name, factory, content values

        if (res == -1)
            return "Failed";
        else
            return "Register Successful";
    }

}