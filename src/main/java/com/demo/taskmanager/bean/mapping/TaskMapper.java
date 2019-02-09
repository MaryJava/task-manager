package com.demo.taskmanager.bean.mapping;

import com.demo.taskmanager.bean.TaskBean;
import com.demo.taskmanager.model.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TaskBean convertToTaskBean(Task task) {
        return modelMapper.map(task, TaskBean.class);
    }

    public Task convertToTask(TaskBean taskBean) {
        return modelMapper.map(taskBean, Task.class);
    }
}
