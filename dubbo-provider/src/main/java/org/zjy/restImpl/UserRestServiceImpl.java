package org.zjy.restImpl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.common.RestResponse;
import org.zjy.model.UserModel;
import org.zjy.rest.UserRestService;
import org.zjy.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@DubboService(version = "1.0.0",protocol = {"rest"})
@Path("user")
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    private UserService userService;

    @GET
    @Path("getOne")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public RestResponse<UserModel> getUserById(Integer id) {
        UserModel userModel = userService.getUserById(id);
        return RestResponse.success(null,userModel);
    }

    @GET
    @Path("getAll")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public RestResponse<List<UserModel>> getAllUser() {
        List<UserModel> userModelList = userService.getAllUser();
        return RestResponse.success(null,userModelList);
    }

    @GET
    @Path("deleteUser")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public RestResponse<Boolean> deleteUser(Integer[] ids) {
        Boolean result = userService.deleteUser(ids);
        return RestResponse.success(null,result);
    }

    @GET
    @Path("addUser")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public RestResponse<Boolean> addUser(UserModel userModel) {
        Boolean result = userService.addUser(userModel);
        return RestResponse.success(null,result);
    }

    @GET
    @Path("updateUser")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public RestResponse<Boolean> updateUser(UserModel userModel) {
        Boolean result = userService.updateUser(userModel);
        return RestResponse.success(null,result);
    }
}
