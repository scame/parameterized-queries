package com.scame.parameterizedqueries.di.components;


import com.scame.parameterizedqueries.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
}
