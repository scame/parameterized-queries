package com.scame.parameterizedqueries;


import android.app.Application;

import com.scame.parameterizedqueries.di.components.ApplicationComponent;
import com.scame.parameterizedqueries.di.components.DaggerApplicationComponent;
import com.scame.parameterizedqueries.di.modules.ApplicationModule;
import com.scame.parameterizedqueries.di.modules.DataModule;

public class DbApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildAppComponent();
    }

    private void buildAppComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return applicationComponent;
    }
}
