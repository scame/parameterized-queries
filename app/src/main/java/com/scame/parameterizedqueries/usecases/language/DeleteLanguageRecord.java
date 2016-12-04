package com.scame.parameterizedqueries.usecases.language;


import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.repository.LanguageRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class DeleteLanguageRecord extends UseCaseCompletable {

    private LanguageRepository languageRepository;

    private LanguageModel languageModel;

    public DeleteLanguageRecord(SubscribeOn subscribeOn, ObserveOn observeOn, LanguageRepository languageRepository) {
        super(subscribeOn, observeOn);
        this.languageRepository = languageRepository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return languageRepository.deleteLanguage(languageModel);
    }

    public LanguageModel getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
    }
}
