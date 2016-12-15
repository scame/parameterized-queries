package com.scame.parameterizedqueries.usecases.capital;



public final class CapitalUseCases {

    private final GetAllCapitalsRecords getAllCapitalsRecords;

    private final DeleteCapitalRecord deleteCapitalRecord;

    private final AddCapitalRecord addCapitalRecord;

    private final UpdateCapitalRecord updateCapitalRecord;

    public CapitalUseCases(GetAllCapitalsRecords getAllCapitalsRecords,
                           DeleteCapitalRecord deleteCapitalRecord,
                           AddCapitalRecord addCapitalRecord,
                           UpdateCapitalRecord updateCapitalRecord) {
        this.getAllCapitalsRecords = getAllCapitalsRecords;
        this.deleteCapitalRecord = deleteCapitalRecord;
        this.addCapitalRecord = addCapitalRecord;
        this.updateCapitalRecord = updateCapitalRecord;
    }

    public UpdateCapitalRecord getUpdateCapitalRecord() {
        return updateCapitalRecord;
    }

    public GetAllCapitalsRecords getGetAllCapitalsRecords() {
        return getAllCapitalsRecords;
    }

    public DeleteCapitalRecord getDeleteCapitalRecord() {
        return deleteCapitalRecord;
    }

    public AddCapitalRecord getAddCapitalRecord() {
        return addCapitalRecord;
    }

    public void unsubscribe() {
        updateCapitalRecord.unsubscribe();
        getAllCapitalsRecords.unsubscribe();
        deleteCapitalRecord.unsubscribe();
        addCapitalRecord.unsubscribe();
    }
}
