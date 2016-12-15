package com.scame.parameterizedqueries.usecases.country_lang;


public final class CountryLangsUseCases {

    private final GetAllCountryLangRecords getAllCountryLangRecords;

    private final DeleteCountryLanguagesRecord deleteCountryLanguagesRecord;

    private final AddCountryLanguagesRecord addCountryLanguagesRecord;

    private final UpdateCountryLanguagesRecord updateCountryLanguagesRecord;

    public CountryLangsUseCases(GetAllCountryLangRecords getAllCountryLangRecords,
                                DeleteCountryLanguagesRecord deleteCountryLanguagesRecord,
                                AddCountryLanguagesRecord addCountryLanguagesRecord,
                                UpdateCountryLanguagesRecord updateCountryLanguagesRecord) {
        this.getAllCountryLangRecords = getAllCountryLangRecords;
        this.deleteCountryLanguagesRecord = deleteCountryLanguagesRecord;
        this.addCountryLanguagesRecord = addCountryLanguagesRecord;
        this.updateCountryLanguagesRecord = updateCountryLanguagesRecord;
    }

    public GetAllCountryLangRecords getGetAllCountryLangRecords() {
        return getAllCountryLangRecords;
    }

    public DeleteCountryLanguagesRecord getDeleteCountryLanguagesRecord() {
        return deleteCountryLanguagesRecord;
    }

    public AddCountryLanguagesRecord getAddCountryLanguagesRecord() {
        return addCountryLanguagesRecord;
    }

    public UpdateCountryLanguagesRecord getUpdateCountryLanguagesRecord() {
        return updateCountryLanguagesRecord;
    }

    public void unsubscribe() {
        getAllCountryLangRecords.unsubscribe();
        deleteCountryLanguagesRecord.unsubscribe();
        addCountryLanguagesRecord.unsubscribe();
        updateCountryLanguagesRecord.unsubscribe();
    }
}
