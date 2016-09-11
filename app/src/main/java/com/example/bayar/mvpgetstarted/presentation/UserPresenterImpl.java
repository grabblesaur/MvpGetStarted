package com.example.bayar.mvpgetstarted.presentation;

import android.text.TextUtils;

import com.example.bayar.mvpgetstarted.model.User;
import com.example.bayar.mvpgetstarted.repository.UserRepository;
import com.example.bayar.mvpgetstarted.view.UserView;

public class UserPresenterImpl implements UserPresenter {

    private UserView view;
    private UserRepository userRepository;
    private User u;

    public UserPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void loadUserDetails() {
        int userId = view.getUserId();
        u = userRepository.getUser(userId);
        if (u == null) {
            view.showUserNotFoundMessage();
        } else {
            view.displayFirstName(u.getFirstName());
            view.displayLastName(u.getLastName());
        }
    }

    @Override
    public void setView(UserView view) {
        this.view = view;
    }

    @Override
    public void saveUser() {
        if (u != null) {
            if (TextUtils.isEmpty(view.getFirstName()) || TextUtils.isEmpty(view.getLastName())) {
                view.showUserNameIsRequired();
            } else {
                u.setFirstName(view.getFirstName());
                u.setLastName(view.getLastName());
                userRepository.save(u);
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void resume() {
        loadUserDetails();
    }

    @Override
    public void pause() {

    }
}
