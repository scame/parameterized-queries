package com.scame.parameterizedqueries.usecases.country;


public final class CountryUseCases {

    private final AddCountryRecord addCountryRecord;

    private final DeleteCountryRecord deleteCountryRecord;

    private final GetAllCountriesRecords getAllCountriesRecords;

    private final UpdateCountryRecord updateCountryRecord;

    public CountryUseCases(GetAllCountriesRecords getAllCountriesRecords,
                           DeleteCountryRecord deleteCountryRecord,
                           AddCountryRecord addCountryRecord,
                           UpdateCountryRecord updateCountryRecord) {
        this.getAllCountriesRecords = getAllCountriesRecords;
        this.deleteCountryRecord = deleteCountryRecord;
        this.addCountryRecord = addCountryRecord;
        this.updateCountryRecord = updateCountryRecord;
    }

    public UpdateCountryRecord getUpdateCountryRecord() {
        return updateCountryRecord;
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
        updateCountryRecord.unsubscribe();
        addCountryRecord.unsubscribe();
        deleteCountryRecord.unsubscribe();
        getAllCountriesRecords.unsubscribe();
    }
}
