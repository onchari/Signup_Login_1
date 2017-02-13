package com.example.oncha.signup_login_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by oncha on 2/13/2017.
 */

public class LoginDataBaseAdapter {
    static final String DATABASE_NAME = "login.db";

    static final int DATABASE_VERSION = 1;
    public static int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "LOGIN" +
            "( " + "ID" + " integer primary key autoincrement," + "USERNAME  text,PASSWORD text); ";

    //variable to hold databse instance
    public SQLiteDatabase db;

    // context of the application using the database
    private final Context context;
    private My_DatabaseHelperClass dbHelper ;

    public LoginDataBaseAdapter(Context _context){
        context = _context;
        dbHelper = new My_DatabaseHelperClass(context, DATABASE_NAME,null, DATABASE_VERSION);

    }

    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance(){
        return db;
    }


    public boolean insertEntry(String userName, String passWord) {
        ContentValues newValues = new ContentValues();

        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", passWord);

       long isInserted =  db.insert("LOGIN", "", newValues);
        if(isInserted != -1) {
            return true;
        }
            else {
            return false;
        }
    }
}