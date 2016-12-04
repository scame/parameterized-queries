package com.scame.parameterizedqueries;


import android.app.Application;

import com.scame.parameterizedqueries.di.components.ApplicationComponent;
import com.scame.parameterizedqueries.di.components.DaggerApplicationComponent;
import com.scame.parameterizedqueries.di.modules.ApplicationModule;

public class DbApplication extends Application {

    public static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildAppComponent();
    }

    private void buildAppComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
