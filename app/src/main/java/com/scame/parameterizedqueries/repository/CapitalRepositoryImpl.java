package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.sqlite.CapitalTable;

import java.util.List;

import rx.Completable;
import rx.Single;

public class CapitalRepositoryImpl implements CapitalRepository {

    private CapitalTable capitalTable;

    public CapitalRepositoryImpl(CapitalTable capitalTable) {
        this.capitalTable = capitalTable;
    }

    @Override
    public Completable deleteCapital(CapitalModel capitalModel) {
        capitalTable.deleteRecord(capitalModel);
        return Completable.complete();
    }

    @Override
    public Completable addCapital(CapitalModel capitalModel) {
        capitalTable.addRecord(capitalModel);
        return Completable.complete();
    }

    @Override
    public Single<List<CapitalModel>> getAllCapitals() {
        return Single.defer(() -> Single.just(capitalTable.getAllCapitals()));
    }
}
