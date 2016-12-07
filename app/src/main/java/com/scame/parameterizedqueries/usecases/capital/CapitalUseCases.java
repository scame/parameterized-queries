package com.scame.parameterizedqueries.usecases.capital;



public final class CapitalUseCases {

    private final GetAllCapitalsRecords getAllCapitalsRecords;

    private final DeleteCapitalRecord deleteCapitalRecord;

    private final AddCapitalRecord addCapitalRecord;

    public CapitalUseCases(GetAllCapitalsRecords getAllCapitalsRecords,
                           DeleteCapitalRecord deleteCapitalRecord,
                           AddCapitalRecord addCapitalRecord) {
        this.getAllCapitalsRecords = getAllCapitalsRecords;
        this.deleteCapitalRecord = deleteCapitalRecord;
        this.addCapitalRecord = addCapitalRecord;
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
        getAddCapitalRecord().unsubscribe();
        deleteCapitalRecord.unsubscribe();
        addCapitalRecord.unsubscribe();
    }
}
