package com.demo.taskmanager.service.impl;

import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.model.User;
import com.demo.taskmanager.repository.UserRepository;
import com.demo.taskmanager.service.TaskService;
import com.demo.taskmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskService taskService;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUserWithTasks(User user, Set<Task> tasks) {
        User createdUser = create(user);
        for (Task task : tasks) {
            task.setUser(createdUser);
        }
        taskService.createTasks(tasks);
        return createdUser;
    }

    public User retrieve(String email) {
        return userRepository.findByEmail(email).get();
    }
}
