package com.demo.taskmanager.bean.mapping;

import com.demo.taskmanager.bean.UserBean;
import com.demo.taskmanager.bean.UserWithTasksBean;
import com.demo.taskmanager.model.User;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMappingFacade {

    @Autowired
    private MapperFacade mapperFacade;

    public UserBean getUserBean(User user) {
        return mapperFacade.map(user, UserBean.class);
    }


    public User getUser(UserBean userBean) {
        return mapperFacade.map(userBean, User.class);
    }

    public UserWithTasksBean convertToUserWithTaskBean(User user) {
        return mapperFacade.map(user, UserWithTasksBean.class);
    }

}
