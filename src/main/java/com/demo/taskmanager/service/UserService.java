package com.demo.taskmanager.service;

import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.model.User;

import java.util.Set;

public interface UserService {

    User create(User user);

    User createUserWithTasks(User user, Set<Task> tasks);

    User retrieve(String email);
}
