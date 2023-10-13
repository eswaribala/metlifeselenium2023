package com.example.vebdentalcare;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
class SampleSQLiteDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1502;
    public static final String DATABASE_NAME = "veb_database";
    public static final String CASE_HISTORY_TABLE_NAME = "VEB_CASE_HISTORY";
    public static final String CASE_HISTORY_COLUMN_ID = "CASE_NO";
    public static final String CASE_HISTORY_FIRST_NAME = "FIRST_NAME";
    public static final String CASE_HISTORY_LAST_NAME = "LAST_NAME";
    public static final String CASE_HISTORY_DOB = "DOB";
    public static final String CASE_HISTORY_AGE="AGE";
    public static final String CASE_HISTORY_MOBILENO = "MOBILE_NO";
    public static final String CASE_HISTORY_GENDER = "GENDER";
    public static final String CASE_HISTORY_PHOTO = "PHOTO";
    public static final String CASE_TREATMENT_DONE="TREATMENT_LIST";
    public static final String CASE_REPORT_DATE="DOT";
    public SampleSQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + CASE_HISTORY_TABLE_NAME + " (" +
                CASE_HISTORY_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CASE_HISTORY_FIRST_NAME + " TEXT, " +
                CASE_HISTORY_LAST_NAME + " TEXT, " +
                CASE_HISTORY_DOB + " TEXT, " +
                CASE_HISTORY_AGE + " INTEGER, " +
                CASE_HISTORY_MOBILENO + " LONG, " +
                CASE_HISTORY_GENDER + " TEXT, " +
                CASE_HISTORY_PHOTO + " TEXT, " +
                CASE_TREATMENT_DONE+ " TEXT, " +
                CASE_REPORT_DATE+ " DATETIME DEFAULT CURRENT_TIMESTAMP " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CASE_HISTORY_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}