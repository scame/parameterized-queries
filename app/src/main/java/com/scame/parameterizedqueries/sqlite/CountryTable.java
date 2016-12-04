package com.scame.parameterizedqueries.sqlite;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class CountryTable {

    static final String TABLE_NAME = "country";

    static final String KEY_COUNTRY_ID = "country_id";
    static final String KEY_COUNTRY_NAME = "country_name";
    static final String KEY_POPULATION = "population";

    private DatabaseOpenHelper databaseHelper;

    public CountryTable(DatabaseOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addRecord(CountryModel countryModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_COUNTRY_NAME, countryModel.getName());
            contentValues.put(KEY_POPULATION, countryModel.getPopulation());

            database.insert(TABLE_NAME, null, contentValues);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void deleteRecord(CountryModel countryModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            database.delete(TABLE_NAME, KEY_COUNTRY_ID + " = ?", new String[]{String.valueOf(countryModel.getId())});
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public List<CountryModel> getAllCountries() {
        List<CountryModel> countries = new ArrayList<>();

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                countries = parse(cursor);
            } finally {
                cursor.close();
            }
        }
        return countries;
    }

    private List<CountryModel> parse(Cursor cursor) {
        List<CountryModel> countries = new ArrayList<>();

        int idColumnIndex = cursor.getColumnIndex(KEY_COUNTRY_ID);
        int nameColumnIndex = cursor.getColumnIndex(KEY_COUNTRY_NAME);
        int populationColumnIndex = cursor.getColumnIndex(KEY_POPULATION);

        do {
            int id = cursor.getInt(idColumnIndex);
            String countryName = cursor.getString(nameColumnIndex);
            int population = cursor.getInt(populationColumnIndex);
            countries.add(new CountryModel(id, countryName, population));
        } while (cursor.moveToNext());

        return countries;
    }
}
