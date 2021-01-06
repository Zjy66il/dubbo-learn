package org.zjy.service;

import org.zjy.model.UserModel;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {

    List<UserModel> getAllUser();

    void addUser(UserModel userModel);

    UserModel getUserById(Integer id);

    void updateUser(UserModel userModel);

    void deleteUser(Integer[] ids);
}
