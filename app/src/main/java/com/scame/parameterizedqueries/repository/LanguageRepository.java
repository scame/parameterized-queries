package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.LanguageModel;

import java.util.List;

import rx.Completable;
import rx.Single;

public interface LanguageRepository {

    Completable updateLanguage(LanguageModel languageModel);

    Completable addLanguage(LanguageModel languageModel);

    Completable deleteLanguage(LanguageModel languageModel);

    Single<List<LanguageModel>> getAllLanguages();
}
