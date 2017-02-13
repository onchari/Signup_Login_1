package com.example.oncha.signup_login_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by oncha on 2/13/2017.
 */

public class My_DatabaseHelperClass  extends SQLiteOpenHelper{


    public My_DatabaseHelperClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase _db) {
        _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {

        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        // Create a new one.
        onCreate(_db);
    }
}
