package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.FirstQueryModel;
import com.scame.parameterizedqueries.sqlite.CountryTable;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;
import com.scame.parameterizedqueries.sqlite.LanguageTable;

import java.util.ArrayList;
import java.util.List;

public class FirstQuery {

    private DatabaseOpenHelper openHelper;

    public FirstQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<FirstQueryModel> execFirstQuery(int nativeSpeakers) {
        List<FirstQueryModel> firstQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getFirstQueryStatement(nativeSpeakers), null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                firstQueryModels = parseFirstQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return firstQueryModels;
    }

    private String getFirstQueryStatement(int nativeSpeakers) {
        return "SELECT country.country_name, language.language_name, language.native_speakers, language.language_family " +
                "FROM country, language, country_languages " +
                "WHERE language.native_speakers > " + nativeSpeakers + " AND " +
                "country.country_id = country_languages.country_id AND " +
                "country_languages.language_id = language.language_id";
    }

    private List<FirstQueryModel> parseFirstQuery(Cursor cursor) {
        List<FirstQueryModel> firstQueryModels = new ArrayList<>();

        int countryNameIndex = cursor.getColumnIndex(CountryTable.KEY_COUNTRY_NAME);
        int languageNameIndex = cursor.getColumnIndex(LanguageTable.KEY_LANGUAGE_NAME);
        int nativeSpeakersIndex = cursor.getColumnIndex(LanguageTable.KEY_NATIVE_SPEAKERS);

        do {
            String countryName = cursor.getString(countryNameIndex);
            String languageName = cursor.getString(languageNameIndex);
            int nativeSpeakers = cursor.getInt(nativeSpeakersIndex);

            firstQueryModels.add(new FirstQueryModel(countryName, languageName, nativeSpeakers));
        } while (cursor.moveToNext());

        return firstQueryModels;
    }
}
