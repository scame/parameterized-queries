package com.scame.parameterizedqueries.usecases.language;


import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.repository.LanguageRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class UpdateLanguageRecord extends UseCaseCompletable {

    private LanguageRepository languageRepository;

    private LanguageModel languageModel;

    public UpdateLanguageRecord(SubscribeOn subscribeOn, ObserveOn observeOn, LanguageRepository languageRepository) {
        super(subscribeOn, observeOn);
        this.languageRepository = languageRepository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return languageRepository.updateLanguage(languageModel);
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
    }

    public LanguageModel getLanguageModel() {
        return languageModel;
    }
}
