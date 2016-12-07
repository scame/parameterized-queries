package com.scame.parameterizedqueries.usecases.language;



public final class LanguageUseCases {

    private final GetAllLanguagesRecords getAllLanguagesRecords;

    private final DeleteLanguageRecord deleteLanguageRecord;

    private final AddLanguageRecord addLanguageRecord;

    public LanguageUseCases(GetAllLanguagesRecords getAllLanguagesRecords,
                            DeleteLanguageRecord deleteLanguageRecord,
                            AddLanguageRecord addLanguageRecord) {
        this.getAllLanguagesRecords = getAllLanguagesRecords;
        this.deleteLanguageRecord = deleteLanguageRecord;
        this.addLanguageRecord = addLanguageRecord;
    }

    public GetAllLanguagesRecords getGetAllLanguagesRecords() {
        return getAllLanguagesRecords;
    }

    public DeleteLanguageRecord getDeleteLanguageRecord() {
        return deleteLanguageRecord;
    }

    public AddLanguageRecord getAddLanguageRecord() {
        return addLanguageRecord;
    }
}
