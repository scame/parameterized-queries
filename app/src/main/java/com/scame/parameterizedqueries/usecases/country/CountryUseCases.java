package com.scame.parameterizedqueries.usecases.country;


public final class CountryUseCases {

    private final AddCountryRecord addCountryRecord;

    private final DeleteCountryRecord deleteCountryRecord;

    private final GetAllCountriesRecords getAllCountriesRecords;

    public CountryUseCases(GetAllCountriesRecords getAllCountriesRecords,
                           DeleteCountryRecord deleteCountryRecord,
                           AddCountryRecord addCountryRecord) {
        this.getAllCountriesRecords = getAllCountriesRecords;
        this.deleteCountryRecord = deleteCountryRecord;
        this.addCountryRecord = addCountryRecord;
    }

    public AddCountryRecord getAddCountryRecord() {
        return addCountryRecord;
    }

    public DeleteCountryRecord getDeleteCountryRecord() {
        return deleteCountryRecord;
    }

    public GetAllCountriesRecords getGetAllCountriesRecords() {
        return getAllCountriesRecords;
    }

    public void unsubscribe() {
        addCountryRecord.unsubscribe();
        deleteCountryRecord.unsubscribe();
        getAllCountriesRecords.unsubscribe();
    }
}
