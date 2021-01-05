package org.zjy.serviceImpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.zjy.dao.UserDao;
import org.zjy.entity.User;
import org.zjy.model.UserModel;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getAllUser() {
        List<User> userList = userDao.getAllUser();
        System.out.println(userList.size());
    }
}