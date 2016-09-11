package com.example.bayar.mvpgetstarted;

import com.example.bayar.mvpgetstarted.view.fragment.UserFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(UserFragment target);

}
