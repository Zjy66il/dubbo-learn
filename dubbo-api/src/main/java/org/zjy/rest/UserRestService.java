package org.zjy.rest;

import org.zjy.common.RestResponse;
import org.zjy.model.UserModel;

import java.util.List;

public interface UserRestService {

    RestResponse<UserModel> getUserById(Integer id);

    RestResponse<List<UserModel>> getAllUser();

    RestResponse<Boolean> deleteUser(Integer[] ids);

    RestResponse<Boolean> addUser(UserModel userModel);

    RestResponse<Boolean> updateUser(UserModel userModel);

}
