package com.scame.parameterizedqueries.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    private static final String DB_NAME = "countries";

    public DatabaseOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCountryTableStatement());
        db.execSQL(getCapitalTableStatement());
        db.execSQL(getLanguageTableStatement());
        db.execSQL(getCountryLanguagesBridgeTableStatement());
    }

    private String getCountryTableStatement() {
        return "CREATE TABLE " + CountryTable.TABLE_NAME +
                "(" +
                CountryTable.KEY_COUNTRY_ID + " INTEGER PRIMARY KEY," +
                CountryTable.KEY_COUNTRY_NAME + " TEXT," +
                CountryTable.KEY_POPULATION + " INTEGER" +
                ")";
    }

    private String getCapitalTableStatement() {
        return "CREATE TABLE " + CapitalTable.TABLE_NAME +
                "(" +
                CapitalTable.KEY_CAPITAL_ID + " INTEGER PRIMARY KEY," +
                CapitalTable.KEY_COUNTRY_ID + " INTEGER," +
                CapitalTable.KEY_CAPITAL_NAME + " TEXT," +
                CapitalTable.KEY_POPULATION + " INTEGER" +
                ")";
    }

    private String getLanguageTableStatement() {
        return "CREATE TABLE " + LanguageTable.TABLE_NAME +
                "(" +
                LanguageTable.KEY_LANGUAGE_ID + " INTEGER PRIMARY KEY," +
                LanguageTable.KEY_LANGUAGE_NAME + " TEXT," +
                LanguageTable.KEY_LANGUAGE_FAMILY + " TEXT," +
                LanguageTable.KEY_NATIVE_SPEAKERS + " INTEGER" +
                ")";
    }

    private String getCountryLanguagesBridgeTableStatement() {
        return "CREATE TABLE " + CountryLanguagesBridgeTable.TABLE_NAME +
                "(" +
                CountryLanguagesBridgeTable.KEY_ID + " INTEGER PRIMARY KEY," +
                CountryLanguagesBridgeTable.KEY_COUNTRY_ID + " INTEGER," +
                CountryLanguagesBridgeTable.KEY_LANGUAGE_ID + " INTEGER" +
                ")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + CountryTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + CapitalTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + LanguageTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + CountryLanguagesBridgeTable.TABLE_NAME);
            onCreate(db);
        }
    }
}
