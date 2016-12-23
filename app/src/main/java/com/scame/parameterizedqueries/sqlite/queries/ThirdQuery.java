package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.ThirdQueryModel;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;
import com.scame.parameterizedqueries.sqlite.LanguageTable;

import java.util.ArrayList;
import java.util.List;

public class ThirdQuery {

    private DatabaseOpenHelper openHelper;

    public ThirdQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<ThirdQueryModel> execThirdQuery(int countriesNumber) {
        List<ThirdQueryModel> thirdQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getThirdQueryStatement(countriesNumber), null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                thirdQueryModels = parseThirdQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return thirdQueryModels;
    }

    private String getThirdQueryStatement(int countriesNumber) {
        return "SELECT language.language_name, COUNT(country.country_id) as countries_number " +
                "FROM (country_languages JOIN country " +
                "ON country.country_id = country_languages.country_id) " +
                "JOIN language ON language.language_id = country_languages.language_id " +
                "GROUP BY language.language_id " +
                "HAVING countries_number > " + countriesNumber;
    }

    private List<ThirdQueryModel> parseThirdQuery(Cursor cursor) {
        List<ThirdQueryModel> thirdQueryModels = new ArrayList<>();

        int languageNameIndex = cursor.getColumnIndex(LanguageTable.KEY_LANGUAGE_NAME);
        int countriesNumberIndex = cursor.getColumnIndex("countries_number");

        do {
            String languageName = cursor.getString(languageNameIndex);
            int countriesNumber = cursor.getInt(countriesNumberIndex);

            thirdQueryModels.add(new ThirdQueryModel(languageName, countriesNumber));
        } while (cursor.moveToNext());

        return thirdQueryModels;
    }
}
