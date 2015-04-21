package com.example.s9942162b.homework3;

/**
 * Created by s9942162b on 4/16/2015.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DbOperator extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB_NAME";
    protected static final String FIRST_TABLE_NAME = "FIRST_TABLE";
    protected static final String SECOND_TABLE_NAME = "SECOND_TABLE";

    public static final String CREATE_FIRST_TABLE = "create table if not exists "
            + FIRST_TABLE_NAME
            + " ( _id integer primary key autoincrement, COL1  TEXT NOT NULL, COL2 TEXT NOT NULL,COL3 TEXT, COL4 int, COL5 TEXT,"
            + "COL6 TEXT,COL7 REAL, COL8 INTEGER,COL9 TEXT not null);";

    public static final String CREATE_SECOND_TABLE = "create table if not exists "
            + SECOND_TABLE_NAME
            + " ( _id integer primary key autoincrement, COL1  TEXT NOT NULL, COL2 TEXT NOT NULL,COL3 TEXT, COL4 int, COL5 TEXT,"
            + "COL6 TEXT,COL7 REAL, COL8 INTEGER,COL9 TEXT not null);";

    public DbOperator(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FIRST_TABLE);
        db.execSQL(CREATE_SECOND_TABLE);
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //THIS WILL BE EXECUTED WHEN YOU UPDATED VERSION OF DATABASE_VERSION
        //YOUR DROP AND CREATE QUERIES
    }
}