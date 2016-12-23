package com.scame.parameterizedqueries.di.components;


import com.scame.parameterizedqueries.di.PerActivity;
import com.scame.parameterizedqueries.di.modules.QueriesModule;
import com.scame.parameterizedqueries.fragments.QueryFragment;

import dagger.Component;

@Component(modules = QueriesModule.class, dependencies = ApplicationComponent.class)
@PerActivity
public interface QueriesComponent {

    void inject(QueryFragment queryFragment);
}
