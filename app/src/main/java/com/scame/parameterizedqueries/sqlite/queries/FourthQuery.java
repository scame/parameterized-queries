package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.FourthQueryModel;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;
import com.scame.parameterizedqueries.sqlite.LanguageTable;

import java.util.ArrayList;
import java.util.List;

public class FourthQuery {

    private DatabaseOpenHelper openHelper;

    public FourthQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<FourthQueryModel> execFourthQuery(int capitalPopulation) {
        List<FourthQueryModel> fourthQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getFourthQueryStatement(capitalPopulation), null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                fourthQueryModels = parseFourthQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return fourthQueryModels;
    }

    private String getFourthQueryStatement(int capitalPopulation) {
        return "SELECT language.language_name " +
                "FROM language " +
                "WHERE language.language_id NOT IN " +
                "(SELECT language.language_id " +
                "FROM ((country JOIN country_languages " +
                "ON country.country_id = country_languages.country_id) JOIN language " +
                "ON country_languages.language_id = language.language_id) JOIN capital " +
                "ON country.country_id = capital.country_id " +
                "WHERE capital.population < " + capitalPopulation + ")";
    }

    private List<FourthQueryModel> parseFourthQuery(Cursor cursor) {
        List<FourthQueryModel> fourthQueryModels = new ArrayList<>();

        int languageNameIndex = cursor.getColumnIndex(LanguageTable.KEY_LANGUAGE_NAME);

        do {
            String languageName = cursor.getString(languageNameIndex);
            fourthQueryModels.add(new FourthQueryModel(languageName));
        } while (cursor.moveToNext());

        return fourthQueryModels;
    }
}
