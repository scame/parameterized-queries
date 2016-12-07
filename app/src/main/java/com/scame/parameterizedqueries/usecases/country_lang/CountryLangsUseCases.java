package com.scame.parameterizedqueries.usecases.country_lang;


public final class CountryLangsUseCases {

    private final GetAllCountryLangRecords getAllCountryLangRecords;

    private final DeleteCountryLanguagesRecord deleteCountryLanguagesRecord;

    private final AddCountryLanguagesRecord addCountryLanguagesRecord;

    public CountryLangsUseCases(GetAllCountryLangRecords getAllCountryLangRecords,
                                DeleteCountryLanguagesRecord deleteCountryLanguagesRecord,
                                AddCountryLanguagesRecord addCountryLanguagesRecord) {
        this.getAllCountryLangRecords = getAllCountryLangRecords;
        this.deleteCountryLanguagesRecord = deleteCountryLanguagesRecord;
        this.addCountryLanguagesRecord = addCountryLanguagesRecord;
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

    public void unsubscribe() {
        getAllCountryLangRecords.unsubscribe();
        deleteCountryLanguagesRecord.unsubscribe();
        addCountryLanguagesRecord.unsubscribe();
    }
}
