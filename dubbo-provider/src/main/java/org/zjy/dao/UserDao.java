package org.zjy.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.zjy.entity.User;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getAllUser();

    void addUser(User userEntity);

    User getUserById(Integer id);

    void updateUser(User userEntity);

    void deleteUserById(Integer id);
}
