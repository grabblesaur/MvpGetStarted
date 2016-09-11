package com.example.bayar.mvpgetstarted.presentation;

import com.example.bayar.mvpgetstarted.view.UserView;

public interface UserPresenter extends LifecyclePresenter{
    void loadUserDetails();
    void setView(UserView view);
    void saveUser();
}
