package com.demo.taskmanager.service;

import com.demo.taskmanager.model.User;

public interface UserService {

    User create(User user);

    User retrieve(String email);
}
