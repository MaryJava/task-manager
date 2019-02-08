package com.demo.taskmanager.bean;

import java.io.Serializable;
import java.util.List;

public class UserWithTasksBean implements Serializable {

    private List<TaskBean> tasksList;

    public UserWithTasksBean() {
    }

    public UserWithTasksBean(List<TaskBean> tasksList) {
        this.tasksList = tasksList;
    }

    public List<TaskBean> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<TaskBean> tasksList) {
        this.tasksList = tasksList;
    }
}
