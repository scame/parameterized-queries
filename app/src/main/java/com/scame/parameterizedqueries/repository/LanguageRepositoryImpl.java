package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.sqlite.LanguageTable;

import java.util.List;

import rx.Completable;
import rx.Single;

public class LanguageRepositoryImpl implements LanguageRepository {

    private LanguageTable languageTable;

    public LanguageRepositoryImpl(LanguageTable languageTable) {
        this.languageTable = languageTable;
    }

    @Override
    public Completable addLanguage(LanguageModel languageModel) {
        languageTable.addRecord(languageModel);
        return Completable.complete();
    }

    @Override
    public Completable deleteLanguage(LanguageModel languageModel) {
        languageTable.deleteRecord(languageModel);
        return Completable.complete();
    }

    @Override
    public Single<List<LanguageModel>> getAllLanguages() {
        return Single.defer(() -> Single.just(languageTable.getAllLanguages()));
    }
}
