package org.zjy.serviceImpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.zjy.dao.TUserMapper;
import org.zjy.entity.TUser;
import org.zjy.model.UserModel;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration()
public class UserServiceImplTest {

    @Autowired
    private TUserMapper userMapper;

    @Test
    public void getAllUser() {
        TUser tUser = userMapper.selectByPrimaryKey(1);
        System.out.println(tUser.getName());
    }
}