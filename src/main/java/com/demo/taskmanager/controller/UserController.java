package com.demo.taskmanager.controller;


import com.demo.taskmanager.bean.TaskBean;
import com.demo.taskmanager.bean.UserBean;
import com.demo.taskmanager.bean.UserWithTasksBean;
import com.demo.taskmanager.bean.mapping.TaskMapper;
import com.demo.taskmanager.bean.mapping.UserMapper;
import com.demo.taskmanager.model.Status;
import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.model.User;
import com.demo.taskmanager.service.TaskService;
import com.demo.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
    private UserMapper userMapper;

    @Autowired
    private TaskMapper taskMapper;

    @PostMapping("/users")
    public UserBean createUser(@RequestBody UserBean userBean) {
        User user = userService.create(userMapper.convertToUser(userBean));
        return userMapper.convertToUserBean(user);
    }

    @PostMapping("/users/userwithtasks")
    public UserWithTasksBean createUserWithTasks(@RequestBody UserWithTasksBean userWithTasksBean) {

        User user = userMapper.convertToUser(userWithTasksBean);
        Set<Task> tasks = new HashSet<>();
        for (TaskBean taskBean : userWithTasksBean.getTasksList()) {
            Task task = taskMapper.convertToTask(taskBean);
            tasks.add(task);
        }
        user.setTasks(tasks);
        User createdUser = userService.createUserWithTasks(user, tasks);
        return (UserWithTasksBean) userMapper.convertToUserBean(createdUser);
    }


    @GetMapping("/users/{email}/user")
    public UserBean User(@PathVariable(value = "email") String email) {
        User user = userService.retrieve(email);
        UserBean userBean = userMapper.convertToUserBean(user);
        return userBean;
    }

    /*@PostMapping("/users/userwithtasks")
    public UserWithTasksBean createUserWithTasks(@RequestBody UserWithTasksBean userWithTasksBean) {

        Assert.isTrue(userWithTasksBean.getTasksList() != null && userWithTasksBean.getTasksList().size() > 0,
                "At least one task must be provided with user");
        User user = userMapper.getUser(userWithTasksBean);
        Set<Task> tasks = new HashSet<>();
        for (TaskBean taskBean : userWithTasksBean.getTasksList()) {
            Task task = taskMapper.getTask(taskBean);
            tasks.add(task);
        }
        user.setTasks(tasks);
        User createdUser = userService.create(user);
        return (UserWithTasksBean) userMapper.getUserBean(createdUser);
    }*/
}
