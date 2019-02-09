package com.demo.taskmanager.controller;

import com.demo.taskmanager.bean.TaskBean;
import com.demo.taskmanager.bean.mapping.TaskMapper;
import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;


    @PostMapping("/tasks")
    public TaskBean create(@RequestBody TaskBean taskBean) {
        //TODO fix createdAt null
        Task createdTask = taskService.create(taskMapper.convertToTask(taskBean));
        return taskMapper.convertToTaskBean(createdTask);

    }
}
