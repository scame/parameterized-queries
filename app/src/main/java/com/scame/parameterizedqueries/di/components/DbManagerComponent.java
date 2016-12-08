package com.scame.parameterizedqueries.di.components;


import com.scame.parameterizedqueries.di.PerActivity;
import com.scame.parameterizedqueries.di.modules.DbManagerModule;
import com.scame.parameterizedqueries.fragments.DbManagerFragment;

import dagger.Component;

@PerActivity
@Component(modules = DbManagerModule.class, dependencies = ApplicationComponent.class)
public interface DbManagerComponent {

    void inject(DbManagerFragment dbManagerFragment);
}
