package com.example.bayar.mvpgetstarted;

import com.example.bayar.mvpgetstarted.presentation.UserPresenter;
import com.example.bayar.mvpgetstarted.presentation.UserPresenterImpl;
import com.example.bayar.mvpgetstarted.repository.InMemoryUserRepositoryImpl;
import com.example.bayar.mvpgetstarted.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides @Singleton
    public UserRepository provideUserRepository() {
        return new InMemoryUserRepositoryImpl();
    }

    @Provides
    public UserPresenter provideUserPresenter(UserRepository userRepository) {
        return new UserPresenterImpl(userRepository);
    }

}
