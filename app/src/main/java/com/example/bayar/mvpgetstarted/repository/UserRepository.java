package com.example.bayar.mvpgetstarted.repository;

import com.example.bayar.mvpgetstarted.model.User;

public interface UserRepository {
    User getUser(int id);
    void save(User u);
}
