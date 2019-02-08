package com.demo.taskmanager.controller;


import com.demo.taskmanager.bean.UserBean;

import com.demo.taskmanager.bean.mapping.UserMapper;
import com.demo.taskmanager.model.User;
import com.demo.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/users")
    public UserBean createUser(@RequestBody UserBean userBean) {
        User user = userService.create(userMapper.getUser(userBean));
        return userMapper.getUserBean(user);
    }

    @GetMapping("/users/{email}/user")
    public UserBean User(@PathVariable(value = "email") String email) {
        User user = userService.retrieve(email);
        UserBean userBean = userMapper.getUserBean(user);
        return userBean;
    }
}
