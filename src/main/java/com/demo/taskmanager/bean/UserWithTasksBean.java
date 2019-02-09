package com.demo.taskmanager.bean;

import java.util.Set;

public class UserWithTasksBean extends UserBean {

    private Set<TaskBean> tasksList;

    public Set<TaskBean> getTasksList() {
        return tasksList;
    }

    public void setTasksList(Set<TaskBean> tasksList) {
        this.tasksList = tasksList;
    }
}
