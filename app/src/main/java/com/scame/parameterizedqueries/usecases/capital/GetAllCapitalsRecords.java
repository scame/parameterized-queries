package com.scame.parameterizedqueries.usecases.capital;


import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.repository.CapitalRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class GetAllCapitalsRecords extends UseCaseSingle<List<CapitalModel>> {

    private CapitalRepository capitalRepository;

    public GetAllCapitalsRecords(SubscribeOn subscribeOn, ObserveOn observeOn, CapitalRepository capitalRepository) {
        super(subscribeOn, observeOn);
        this.capitalRepository = capitalRepository;
    }

    @Override
    protected Single<List<CapitalModel>> getUseCaseSingle() {
        return capitalRepository.getAllCapitals();
    }
}
