package com.scame.parameterizedqueries.sqlite;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.CountryLanguagesModel;

import java.util.ArrayList;
import java.util.List;

public class CountryLanguagesBridgeTable {

    static final String TABLE_NAME = "country_languages";

    static final String KEY_ID = "id";
    static final String KEY_COUNTRY_ID = "country_id";
    static final String KEY_LANGUAGE_ID = "language_id";

    private DatabaseOpenHelper databaseHelper;

    public CountryLanguagesBridgeTable(DatabaseOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addRecord(CountryLanguagesModel countryLanguagesModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_COUNTRY_ID, countryLanguagesModel.getCountryId());
            contentValues.put(KEY_LANGUAGE_ID, countryLanguagesModel.getLanguageId());

            database.insert(TABLE_NAME, null, contentValues);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void deleteRecord(CountryLanguagesModel countryLanguagesModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            database.delete(TABLE_NAME, KEY_ID + " = ?", new String[]{String.valueOf(countryLanguagesModel.getId())});
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public int updateRecord(CountryLanguagesModel countryLanguagesModel) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COUNTRY_ID, countryLanguagesModel.getCountryId());
        values.put(KEY_LANGUAGE_ID, countryLanguagesModel.getLanguageId());

        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(countryLanguagesModel.getId()) });
    }

    public List<CountryLanguagesModel> getAllCountriesLanguages() {
        List<CountryLanguagesModel> countriesLanguages = new ArrayList<>();

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                countriesLanguages = parse(cursor);
            } finally {
                cursor.close();
            }
        }
        return countriesLanguages;
    }

    private List<CountryLanguagesModel> parse(Cursor cursor) {
        List<CountryLanguagesModel> countriesLanguages = new ArrayList<>();

        int idColumnIndex = cursor.getColumnIndex(KEY_ID);
        int countryIdColumnIndex = cursor.getColumnIndex(KEY_COUNTRY_ID);
        int languageIdColumnIndex = cursor.getColumnIndex(KEY_LANGUAGE_ID);

        do {
            int id = cursor.getInt(idColumnIndex);
            int countryId = cursor.getInt(countryIdColumnIndex);
            int languageId = cursor.getInt(languageIdColumnIndex);
            countriesLanguages.add(new CountryLanguagesModel(id, countryId, languageId));
        } while (cursor.moveToNext());

        return countriesLanguages;
    }
}
