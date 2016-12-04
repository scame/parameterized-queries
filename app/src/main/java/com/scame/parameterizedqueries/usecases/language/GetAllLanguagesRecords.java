package com.scame.parameterizedqueries.usecases.language;


import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.repository.LanguageRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class GetAllLanguagesRecords extends UseCaseSingle<List<LanguageModel>> {

    private LanguageRepository languageRepository;

    public GetAllLanguagesRecords(SubscribeOn subscribeOn, ObserveOn observeOn, LanguageRepository languageRepository) {
        super(subscribeOn, observeOn);
        this.languageRepository = languageRepository;
    }

    @Override
    protected Single<List<LanguageModel>> getUseCaseSingle() {
        return languageRepository.getAllLanguages();
    }
}
