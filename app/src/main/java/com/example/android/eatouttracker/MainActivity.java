package com.example.android.eatouttracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.eatouttracker.data.EatOutContract;
import com.example.android.eatouttracker.data.EatOutDbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private EatOutDbHelper mDbHelper;

    private int mPrice = 0;

    private String mReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new EatOutDbHelper(this);
    }

    private void insertRestaurant(){
        //Get the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //Converting the String value to integer.
        int review = Integer.parseInt(mReview);
        //Create new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_NAME, "Mendoza Square");
        values.put(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_CUISINE, "Latin American");
        values.put(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_PRICE, mPrice);
        values.put(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_REVIEW, review);


        //Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(EatOutContract.EatOutEntry.TABLE_NAME, null, values);
    }

    private void displayDatabaseInfo() {
        //Get the data repository in write mode
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {EatOutContract.EatOutEntry._ID, EatOutContract.EatOutEntry.COLUMN_RESTAURANT_NAME,
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_CUISINE, EatOutContract.EatOutEntry.COLUMN_RESTAURANT_PRICE,
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_REVIEW};

        Cursor cursor = db.query(EatOutContract.EatOutEntry.TABLE_NAME, projection, null, null, null, null, null);

        try {
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(cursor.getColumnIndex(EatOutContract.EatOutEntry._ID));
                String currentName = cursor.getString(cursor.getColumnIndex(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_NAME));
                String currentCuisine = cursor.getString(cursor.getColumnIndex(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_CUISINE));
                String currentPrice = cursor.getString(cursor.getColumnIndex(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_PRICE));
                String currentReview = cursor.getString(cursor.getColumnIndex(EatOutContract.EatOutEntry.COLUMN_RESTAURANT_REVIEW));
                Log.i(LOG_TAG,
                        "Eat Out Habit -->" + currentID + "-" +
                                currentName + "-" +
                                currentCuisine + "-" +
                                currentPrice + "-" +
                                currentReview + "-");
            }
        } finally {
            //Always close the cursor when you're done reading from it. This releases
            //all its resources and makes it invalid/
            cursor.close();
        }
    }
    public Cursor queryAllHabits() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {EatOutContract.EatOutEntry._ID, EatOutContract.EatOutEntry.COLUMN_RESTAURANT_NAME,
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_CUISINE, EatOutContract.EatOutEntry.COLUMN_RESTAURANT_PRICE,
                EatOutContract.EatOutEntry.COLUMN_RESTAURANT_REVIEW};

        Cursor cursor = db.query(EatOutContract.EatOutEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;


    }
}
