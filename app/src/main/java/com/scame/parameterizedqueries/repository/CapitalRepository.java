package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.CapitalModel;

import java.util.List;

import rx.Completable;
import rx.Single;

public interface CapitalRepository {

    Completable deleteCapital(CapitalModel capitalModel);

    Completable addCapital(CapitalModel capitalModel);

    Single<List<CapitalModel>> getAllCapitals();
}
