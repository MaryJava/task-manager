package com.demo.taskmanager.service;

import com.demo.taskmanager.model.Task;

import java.util.Set;

public interface TaskService {

    Task create(Task task);

    Set<Task> createTasks(Set<Task> tasks);

}
