package org.zjy.service;

import org.zjy.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> getAllUser();

    void addUser(UserModel userModel);

    UserModel getUserById(Integer id);

    void updateUser(UserModel userModel);

    void deleteUser(Integer[] ids);
}
