package com.example.android.eatouttracker.data;

import android.provider.BaseColumns;

/**
 * Created by Ikki on 23/07/2017.
 */

public final class EatOutContract {

    public static final class EatOutEntry implements BaseColumns {

        public static final String TABLE_NAME = "restaurants";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_RESTAURANT_NAME = "name";
        public static final String COLUMN_RESTAURANT_CUISINE = "cuisine";
        public static final String COLUMN_RESTAURANT_PRICE = "price";
        public static final String COLUMN_RESTAURANT_REVIEW = "review";

        public static final int PRICE_CHEAP = 0;
        public static final int PRICE_MODERATE = 1;
        public static final int PRICE_EXPENSIVE = 2;

    }
}
