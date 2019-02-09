package com.demo.taskmanager.service.impl;

import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.repository.TaskRepository;
import com.demo.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Set<Task> createTasks(Set<Task> tasks) {
        List<Task> createdTasksList = taskRepository.saveAll(tasks);
        return new HashSet<>(createdTasksList);
    }
}
