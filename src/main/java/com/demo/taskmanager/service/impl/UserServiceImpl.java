package com.demo.taskmanager.service.impl;

import com.demo.taskmanager.model.User;
import com.demo.taskmanager.repository.UserRepository;
import com.demo.taskmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    public User retrieve(String email) {
        return userRepository.findByEmail(email).get();
    }
}
