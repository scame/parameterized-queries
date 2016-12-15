package com.scame.parameterizedqueries.usecases.language;



public final class LanguageUseCases {

    private final GetAllLanguagesRecords getAllLanguagesRecords;

    private final DeleteLanguageRecord deleteLanguageRecord;

    private final AddLanguageRecord addLanguageRecord;

    private final UpdateLanguageRecord updateLanguageRecord;

    public LanguageUseCases(GetAllLanguagesRecords getAllLanguagesRecords,
                            DeleteLanguageRecord deleteLanguageRecord,
                            AddLanguageRecord addLanguageRecord,
                            UpdateLanguageRecord updateLanguageRecord) {
        this.getAllLanguagesRecords = getAllLanguagesRecords;
        this.deleteLanguageRecord = deleteLanguageRecord;
        this.addLanguageRecord = addLanguageRecord;
        this.updateLanguageRecord = updateLanguageRecord;
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

    public UpdateLanguageRecord getUpdateLanguageRecord() {
        return updateLanguageRecord;
    }

    public void unsubscribe() {
        getAllLanguagesRecords.unsubscribe();
        deleteLanguageRecord.unsubscribe();
        addLanguageRecord.unsubscribe();
        updateLanguageRecord.unsubscribe();
    }
}
