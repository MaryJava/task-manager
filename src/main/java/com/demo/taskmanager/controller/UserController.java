package com.demo.taskmanager.controller;


import com.demo.taskmanager.bean.TaskBean;
import com.demo.taskmanager.bean.UserBean;
import com.demo.taskmanager.bean.UserWithTasksBean;
import com.demo.taskmanager.bean.mapping.TaskMapper;
import com.demo.taskmanager.bean.mapping.UserMappingFacade;
import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.model.User;
import com.demo.taskmanager.service.TaskService;
import com.demo.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserMappingFacade userMapper;

    @Autowired
    private TaskMapper taskMapper;

    @PostMapping("/users")
    public UserBean createUser(@RequestBody UserBean userBean) {
        User user = userService.create(userMapper.getUser(userBean));
        return userMapper.getUserBean(user);
    }

    @PostMapping("/users/userwithtasks")
    public UserWithTasksBean createUserWithTasks(@RequestBody UserWithTasksBean userWithTasksBean) {
        User user = userMapper.getUser(userWithTasksBean);
        Set<Task> tasks = new HashSet<>();
        for (TaskBean taskBean : userWithTasksBean.getTasks()) {
            Task task = taskMapper.convertToTask(taskBean);
            tasks.add(task);
        }
        user.setTasks(tasks);
        User createdUser = userService.createUserWithTasks(user, tasks);
        return userMapper.convertToUserWithTaskBean(createdUser);
    }


    @GetMapping("/users/{email}/user")
    public UserBean User(@PathVariable(value = "email") String email) {
        User user = userService.retrieve(email);
        UserBean userBean = userMapper.getUserBean(user);
        return userBean;
    }
}
