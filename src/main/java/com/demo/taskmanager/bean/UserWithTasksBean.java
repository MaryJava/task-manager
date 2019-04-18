package com.demo.taskmanager.bean;

import java.util.Set;

public class UserWithTasksBean extends UserBean {

    private Set<TaskBean> tasks;

    public Set<TaskBean> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskBean> tasks) {
        this.tasks = tasks;
    }
}
