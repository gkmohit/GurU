package com.unknown.gkmohit.guru.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by AirUnknown on 15-10-11.
 */
public final class UserListContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public Context mContext;
    public UserListDbHelper mUserListDbHelper;
    public SQLiteDatabase mDb;

    public UserListContract() {
        mUserListDbHelper = new UserListDbHelper(mContext);
    }

    /* Inner class that defines the table contents */
    public static abstract class UserList implements BaseColumns {
        public static final String TABLE_NAME = "user_list";
        public static final String COLUMN_NAME_USER_ID = "userid";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_FULL_NAME = "fullname";
        public static final String COLUMN_NAME_PHONE_NUMBER = "phonenumber";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_IS_MENTOR = "ismentor";
        public static final String COLUMN_NAME_UNIVERSITY = "university";
        public static final String COLUMN_NAME_SKILLS = "skills";
        public static final String COLUMN_NAME_RATINGS = "ratings";
        public static final String COLUMN_NAME_BACKGROUND = "background";
        public static final String COLUMN_NAME_BANK_CUSTOMER_ID = "customerid";
        public static final String COLUMN_NAME_NO_OF_ACCOUNTS = "numberofaccounts";
        public static final String TEXT_TYPE = "TEXT";
        public static final String INTEGER_TYPE = "INTEGER";
        public static final String COMMA_SEP = ",";
    }

    public class UserListDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;

        public static final String DATABASE_NAME = "UserList.db";

        private final String SQL_CREATE_ENTRIES =
                "CREATE TABLE" + UserList.TABLE_NAME + "(" +
                        UserList._ID + " INTEGER PRIMARY KEY," +
                        UserList.COLUMN_NAME_USER_ID + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_USERNAME + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_EMAIL + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_FULL_NAME + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_PHONE_NUMBER + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_ADDRESS + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_IS_MENTOR + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_UNIVERSITY + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_SKILLS + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_RATINGS + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_BACKGROUND + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_BANK_CUSTOMER_ID + UserList.TEXT_TYPE + UserList.COMMA_SEP +
                        UserList.COLUMN_NAME_NO_OF_ACCOUNTS + UserList.INTEGER_TYPE +
                        // Any other options for the CREATE command
                        " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + UserList.TABLE_NAME;

        public UserListDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}


