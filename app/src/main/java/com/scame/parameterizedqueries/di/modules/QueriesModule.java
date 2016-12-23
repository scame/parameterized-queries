package com.scame.parameterizedqueries.di.modules;

import com.scame.parameterizedqueries.di.PerActivity;
import com.scame.parameterizedqueries.presenters.QueriesPresenter;
import com.scame.parameterizedqueries.presenters.QueriesPresenterImpl;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.queries.EighthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.FifthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.FirstQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.FourthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.SecondQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.SeventhQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.SixthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.ThirdQueryUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class QueriesModule {

    @Provides
    @PerActivity
    QueriesPresenter<QueriesPresenter.QueriesView> provideQueriesPresenter(FirstQueryUseCase firstQueryUseCase,
                                                                           SecondQueryUseCase secondQueryUseCase,
                                                                           ThirdQueryUseCase thirdQueryUseCase,
                                                                           FourthQueryUseCase fourthQueryUseCase,
                                                                           FifthQueryUseCase fifthQueryUseCase,
                                                                           SixthQueryUseCase sixthQueryUseCase,
                                                                           SeventhQueryUseCase seventhQueryUseCase,
                                                                           EighthQueryUseCase eighthQueryUseCase) {
        return new QueriesPresenterImpl<>(firstQueryUseCase, secondQueryUseCase, thirdQueryUseCase,
                fourthQueryUseCase, fifthQueryUseCase, sixthQueryUseCase, seventhQueryUseCase, eighthQueryUseCase);
    }

    @Provides
    @PerActivity
    FirstQueryUseCase provideFirstQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new FirstQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    SecondQueryUseCase provideSecondQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new SecondQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    ThirdQueryUseCase provideThirdQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new ThirdQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    FourthQueryUseCase provideFourthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new FourthQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    FifthQueryUseCase provideFifthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new FifthQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    SixthQueryUseCase provideSixthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new SixthQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    SeventhQueryUseCase provideSeventhQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new SeventhQueryUseCase(subscribeOn, observeOn, dispatcher);
    }

    @Provides
    @PerActivity
    EighthQueryUseCase provideEightQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        return new EighthQueryUseCase(subscribeOn, observeOn, dispatcher);
    }
}
