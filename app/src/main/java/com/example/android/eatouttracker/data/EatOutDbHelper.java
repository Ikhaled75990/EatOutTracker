package com.example.android.eatouttracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ikki on 23/07/2017.
 */

public class EatOutDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database
     */
    public static final String DATABASE_NAME = "eatout.db";

    /**
     * Version of the database.
     */
    public static final int DATABASE_VERSION = 1;


    public EatOutDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * This method is called when the database is create for the 1st time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create a String that contains the SQL statement to create the restaurant's table.
        String SQ_LITE_CREATE_RESTAURANT_TABLE = "CREATE TABLE " + EatOutContract.EatOutEntry.TABLE_NAME +
                " (" + EatOutContract.EatOutEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_NAME + " TEXT NOT NULL, " +
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_CUISINE + " TEXT, " +
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_PRICE + " TEXT NOT NULL, " +
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_REVIEW + " INTEGER NOT NULL);";
        db.execSQL(SQ_LITE_CREATE_RESTAURANT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
