package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.SecondQueryModel;
import com.scame.parameterizedqueries.sqlite.CountryTable;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;
import com.scame.parameterizedqueries.sqlite.LanguageTable;

import java.util.ArrayList;
import java.util.List;

public class SecondQuery {

    private DatabaseOpenHelper openHelper;

    public SecondQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<SecondQueryModel> execSecondQuery(String languageFamily) {
        List<SecondQueryModel> secondQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getSecondQueryStatement(), new String[] {languageFamily});

        if (cursor != null && cursor.moveToFirst()) {
            try {
                secondQueryModels = parseSecondQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return secondQueryModels;
    }

    private String getSecondQueryStatement() {
        return "SELECT country.country_name, language.language_family " +
                "FROM country, language, country_languages " +
                "WHERE country.country_id NOT IN (" +
                    "SELECT country.country_id " +
                    "FROM country, language, country_languages " +
                    "WHERE language.language_family = ? " +
                    "AND country.country_id = country_languages.country_id " +
                    "AND country_languages.language_id = language.language_id) " +
                "AND country.country_id = country_languages.country_id " +
                "AND language.language_id = country_languages.language_id";
    }

    private List<SecondQueryModel> parseSecondQuery(Cursor cursor) {
        List<SecondQueryModel> secondQueryModels = new ArrayList<>();

        int countryNameIndex = cursor.getColumnIndex(CountryTable.KEY_COUNTRY_NAME);
        int languageFamilyIndex = cursor.getColumnIndex(LanguageTable.KEY_LANGUAGE_FAMILY);

        do {
            String countryName = cursor.getString(countryNameIndex);
            String languageFamily = cursor.getString(languageFamilyIndex);
            secondQueryModels.add(new SecondQueryModel(countryName, languageFamily));
        } while (cursor.moveToNext());

        return secondQueryModels;
    }
}
