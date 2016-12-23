package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.SeventhQueryModel;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;
import com.scame.parameterizedqueries.sqlite.LanguageTable;

import java.util.ArrayList;
import java.util.List;

public class SeventhQuery {

    private DatabaseOpenHelper openHelper;

    public SeventhQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<SeventhQueryModel> execSeventhQuery(int countryPopulation) {
        List<SeventhQueryModel> seventhQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getSeventhQueryStatement(countryPopulation), null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                seventhQueryModels = parseSeventhQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return seventhQueryModels;
    }

    private String getSeventhQueryStatement(int countryPopulation) {
        return "SELECT language_name " +
                "FROM language " +
                "WHERE language.language_id NOT IN (SELECT language.language_id " +
                "FROM (country JOIN country_languages " +
                "ON country.country_id = country_languages.country_id) JOIN language " +
                "ON country_languages.language_id = language.language_id " +
                "WHERE country.population < " + countryPopulation + ")";
    }

    private List<SeventhQueryModel> parseSeventhQuery(Cursor cursor) {
        List<SeventhQueryModel> seventhQueryModels = new ArrayList<>();

        int languageNameIndex = cursor.getColumnIndex(LanguageTable.KEY_LANGUAGE_NAME);
        do {
            String languageName = cursor.getString(languageNameIndex);
            seventhQueryModels.add(new SeventhQueryModel(languageName));
        } while (cursor.moveToNext());

        return seventhQueryModels;
    }
}
