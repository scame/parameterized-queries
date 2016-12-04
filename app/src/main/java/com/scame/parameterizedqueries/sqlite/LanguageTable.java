package com.scame.parameterizedqueries.sqlite;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.LanguageModel;

import java.util.ArrayList;
import java.util.List;

public class LanguageTable {

    static final String TABLE_NAME = "language";

    static final String KEY_LANGUAGE_ID = "language_id";
    static final String KEY_LANGUAGE_NAME = "language_name";
    static final String KEY_NATIVE_SPEAKERS = "native_speakers";
    static final String KEY_LANGUAGE_FAMILY = "language_family";

    private DatabaseOpenHelper databaseHelper;

    public LanguageTable(DatabaseOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addRecord(LanguageModel languageModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_LANGUAGE_NAME, languageModel.getName());
            contentValues.put(KEY_NATIVE_SPEAKERS, languageModel.getNativeSpeakers());
            contentValues.put(KEY_LANGUAGE_FAMILY, languageModel.getLanguageFamily());

            database.insert(TABLE_NAME, null, contentValues);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void deleteRecord(LanguageModel languageModel) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        database.beginTransaction();
        try {
            database.delete(TABLE_NAME, KEY_LANGUAGE_ID + " = ?", new String[]{String.valueOf(languageModel.getId())});
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public List<LanguageModel> getAllLanguages() {
        List<LanguageModel> languages = new ArrayList<>();

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                languages = parseCursor(cursor);
            } finally {
                cursor.close();
            }
        }
        return languages;
    }

    private List<LanguageModel> parseCursor(Cursor cursor) {
        List<LanguageModel> languages = new ArrayList<>();

        int idColumnIndex = cursor.getColumnIndex(KEY_LANGUAGE_ID);
        int nameColumnIndex = cursor.getColumnIndex(KEY_LANGUAGE_NAME);
        int nativeSpeakersIndex = cursor.getColumnIndex(KEY_NATIVE_SPEAKERS);
        int languageFamilyIndex = cursor.getColumnIndex(KEY_LANGUAGE_FAMILY);

        do {
            int id = cursor.getInt(idColumnIndex);
            String countryName = cursor.getString(nameColumnIndex);
            int nativeSpeakersNumber = cursor.getInt(nativeSpeakersIndex);
            String languageFamily = cursor.getString(languageFamilyIndex);
            languages.add(new LanguageModel(id, countryName, nativeSpeakersNumber, languageFamily));
        } while (cursor.moveToNext());

        return languages;
    }
}
