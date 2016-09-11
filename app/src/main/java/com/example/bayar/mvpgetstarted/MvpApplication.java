package com.example.bayar.mvpgetstarted;

import android.app.Application;

public class MvpApplication extends Application{

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent
                .builder()
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
