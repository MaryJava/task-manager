package com.demo.taskmanager.bean.mapping;

import com.demo.taskmanager.bean.TaskBean;
import com.demo.taskmanager.bean.UserBean;
import com.demo.taskmanager.bean.UserWithTasksBean;
import com.demo.taskmanager.model.Task;
import com.demo.taskmanager.model.User;
import org.apache.logging.log4j.CloseableThreadContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserBean convertToUserBean(User user) {
        return modelMapper.map(user, UserBean.class);
    }

    public User convertToUser(UserBean userBean) {
        return modelMapper.map(userBean, User.class);
    }

    public UserWithTasksBean convertToUserWithTaskBean(User user) {
        Set<Task> tasks = user.getTasks();
        Set<TaskBean> taskBeans = new HashSet<>();
        for (Task task : tasks) {
            TaskBean taskBean = modelMapper.map(task, TaskBean.class);
            taskBeans.add(taskBean);
        }
        UserWithTasksBean userWithTasksBean = modelMapper.map(user, UserWithTasksBean.class);
        userWithTasksBean.setTasksList(taskBeans);
        return userWithTasksBean;
    }

}
