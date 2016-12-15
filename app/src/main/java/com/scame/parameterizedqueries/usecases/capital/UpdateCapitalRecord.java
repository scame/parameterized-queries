package com.scame.parameterizedqueries.usecases.capital;


import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.repository.CapitalRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class UpdateCapitalRecord extends UseCaseCompletable {

    private CapitalRepository capitalRepository;

    private CapitalModel capitalModel;

    public UpdateCapitalRecord(SubscribeOn subscribeOn, ObserveOn observeOn, CapitalRepository capitalRepository) {
        super(subscribeOn, observeOn);
        this.capitalRepository = capitalRepository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return capitalRepository.updateCapital(capitalModel);
    }

    public void setCapitalModel(CapitalModel capitalModel) {
        this.capitalModel = capitalModel;
    }

    public CapitalModel getCapitalModel() {
        return capitalModel;
    }
}
