package org.zjy.service;

import org.zjy.model.UserModel;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {

    List<UserModel> getAllUser();

    Boolean addUser(UserModel userModel);

    UserModel getUserById(Integer id);

    Boolean updateUser(UserModel userModel);

    Boolean deleteUser(Integer[] ids);
}
