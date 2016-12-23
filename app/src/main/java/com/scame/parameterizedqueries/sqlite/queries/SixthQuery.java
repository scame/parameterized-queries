package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.SixthQueryModel;
import com.scame.parameterizedqueries.sqlite.CountryTable;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SixthQuery {

    private DatabaseOpenHelper openHelper;

    public SixthQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<SixthQueryModel> execSixthQuery(String countryName) {
        List<SixthQueryModel> sixthQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getSixthQueryStatement(), new String[] {countryName, countryName});

        if (cursor != null && cursor.moveToFirst()) {
            try {
                sixthQueryModels = parseSixthQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return sixthQueryModels;
    }

    private String getSixthQueryStatement() {
        return "SELECT DISTINCT country_name " +
                "FROM (country JOIN country_languages " +
                "ON country.country_id = country_languages.country_id) JOIN language " +
                "ON country_languages.language_id = language.language_id " +
                "WHERE country.country_name <> ? AND language.language_family " +
                    "IN (SELECT language.language_family " +
                    "FROM (country JOIN country_languages " +
                    "ON country.country_id = country_languages.country_id) JOIN language " +
                    "ON country_languages.language_id = language.language_id " +
                    "WHERE country.country_name = ?)";
    }

    private List<SixthQueryModel> parseSixthQuery(Cursor cursor) {
        List<SixthQueryModel> sixthQueryModels = new ArrayList<>();

        int countryNameIndex = cursor.getColumnIndex(CountryTable.KEY_COUNTRY_NAME);
        do {
            String countryName = cursor.getString(countryNameIndex);
            sixthQueryModels.add(new SixthQueryModel(countryName));
        } while (cursor.moveToNext());

        return sixthQueryModels;
    }
}
