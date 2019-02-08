package com.demo.taskmanager.controller;


import com.demo.taskmanager.model.User;
import com.demo.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/users/{email}/user")
    public User User(@PathVariable(value = "email") String e) {

        return userService.retrieve(e);
    }
}
