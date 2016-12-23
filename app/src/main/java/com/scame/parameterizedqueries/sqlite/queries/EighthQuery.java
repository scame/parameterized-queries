package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.EighthQueryModel;
import com.scame.parameterizedqueries.sqlite.CountryTable;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class EighthQuery {

    private DatabaseOpenHelper openHelper;

    public EighthQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<EighthQueryModel> execEighthQuery(String languageFamily) {
        List<EighthQueryModel> eighthQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getEightQueryStatement(), new String[] {languageFamily});

        if (cursor != null && cursor.moveToFirst()) {
            try {
                eighthQueryModels = parseEighthQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return eighthQueryModels;
    }

    private String getEightQueryStatement() {
        return "SELECT country.country_name FROM country " +
                "WHERE country.country_id NOT IN (SELECT country.country_id " +
                "FROM (country JOIN country_languages " +
                "ON country.country_id = country_languages.country_id) JOIN language " +
                "ON country_languages.language_id = language.language_id " +
                "WHERE language.language_family <> ?)";
    }

    private List<EighthQueryModel> parseEighthQuery(Cursor cursor) {
        List<EighthQueryModel> eightQueryModels = new ArrayList<>();

        int countryNameIndex = cursor.getColumnIndex(CountryTable.KEY_COUNTRY_NAME);
        do {
            String countryName = cursor.getString(countryNameIndex);
            eightQueryModels.add(new EighthQueryModel(countryName));
        } while (cursor.moveToNext());

        return eightQueryModels;
    }
}
