package com.scame.parameterizedqueries.sqlite.queries;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.scame.parameterizedqueries.models.queries.FifthQueryModel;
import com.scame.parameterizedqueries.sqlite.CapitalTable;
import com.scame.parameterizedqueries.sqlite.CountryTable;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FifthQuery {

    private DatabaseOpenHelper openHelper;

    public FifthQuery(DatabaseOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public List<FifthQueryModel> execFifthQuery(int countryPopulation) {
        List<FifthQueryModel> fifthQueryModels = new ArrayList<>();

        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(getFifthQueryStatement(countryPopulation), null);

        if (cursor != null && cursor.moveToFirst()) {
            try {
                fifthQueryModels = parseFifthQuery(cursor);
            } finally {
                cursor.close();
            }
        }
        return fifthQueryModels;
    }

    private String getFifthQueryStatement(int countryPopulation) {
        return "SELECT capital.capital_name, country.country_name, country.population " +
                "FROM country JOIN capital " +
                "ON country.country_id = capital.country_id " +
                "WHERE country.population < " + countryPopulation;
    }

    private List<FifthQueryModel> parseFifthQuery(Cursor cursor) {
        List<FifthQueryModel> fifthQueryModels = new ArrayList<>();

        int capitalNameIndex = cursor.getColumnIndex(CapitalTable.KEY_CAPITAL_NAME);
        int countryNameIndex = cursor.getColumnIndex(CountryTable.KEY_COUNTRY_NAME);
        int countryPopulationIndex = cursor.getColumnIndex(CountryTable.KEY_POPULATION);

        do {
            String capitalName = cursor.getString(capitalNameIndex);
            String countryName = cursor.getString(countryNameIndex);
            int countryPopulation = cursor.getInt(countryPopulationIndex);

            fifthQueryModels.add(new FifthQueryModel(capitalName, countryName, countryPopulation));
        } while (cursor.moveToNext());

        return fifthQueryModels;
    }
}
