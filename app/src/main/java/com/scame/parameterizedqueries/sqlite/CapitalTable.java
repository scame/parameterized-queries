package com.scame.parameterizedqueries.sqlite;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.CapitalModel;

import java.util.ArrayList;
import java.util.List;

public class CapitalTable {

    public static final String TABLE_NAME = "capital";

    public static final String KEY_CAPITAL_ID = "capital_id";
    public static final String KEY_COUNTRY_ID = "country_id";
    public static final String KEY_CAPITAL_NAME = "capital_name";
    public static final String KEY_POPULATION = "population";

    private DatabaseOpenHelper databaseHelper;

    public CapitalTable(DatabaseOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addRecord(CapitalModel capitalModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_COUNTRY_ID, capitalModel.getCountryId());
            contentValues.put(KEY_CAPITAL_NAME, capitalModel.getName());
            contentValues.put(KEY_POPULATION, capitalModel.getPopulation());

            database.insert(TABLE_NAME, null, contentValues);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void deleteRecord(CapitalModel capitalModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            database.delete(TABLE_NAME, KEY_CAPITAL_ID + " = ?", new String[]{String.valueOf(capitalModel.getId())});
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public int updateRecord(CapitalModel capitalModel) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COUNTRY_ID, capitalModel.getCountryId());
        values.put(KEY_CAPITAL_NAME, capitalModel.getName());
        values.put(KEY_POPULATION, capitalModel.getPopulation());

        return db.update(TABLE_NAME, values, KEY_CAPITAL_ID + " = ?",
                new String[] { String.valueOf(capitalModel.getId()) });
    }

    public List<CapitalModel> getAllCapitals() {
        List<CapitalModel> capitals = new ArrayList<>();

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                capitals = parse(cursor);
            } finally {
                cursor.close();
            }
        }
        return capitals;
    }

    private List<CapitalModel> parse(Cursor cursor) {
        List<CapitalModel> capitals = new ArrayList<>();

        int capitalIdIndex = cursor.getColumnIndex(KEY_CAPITAL_ID);
        int countryIdIndex = cursor.getColumnIndex(KEY_COUNTRY_ID);
        int capitalNameIndex = cursor.getColumnIndex(KEY_CAPITAL_NAME);
        int populationColumnIndex = cursor.getColumnIndex(KEY_POPULATION);

        do {
            int capitalId = cursor.getInt(capitalIdIndex);
            int countryId = cursor.getInt(countryIdIndex);
            String capitalName = cursor.getString(capitalNameIndex);
            int population = cursor.getInt(populationColumnIndex);
            capitals.add(new CapitalModel(capitalId, countryId, capitalName, population));
        } while (cursor.moveToNext());

        return capitals;
    }
}
