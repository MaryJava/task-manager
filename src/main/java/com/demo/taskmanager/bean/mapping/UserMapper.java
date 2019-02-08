package com.demo.taskmanager.bean.mapping;

import com.demo.taskmanager.bean.UserBean;
import com.demo.taskmanager.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserBean getUserBean(User user) {
        return modelMapper.map(user, UserBean.class);
    }

    public User getUser(UserBean userBean) {
        return modelMapper.map(userBean, User.class);
    }
}
