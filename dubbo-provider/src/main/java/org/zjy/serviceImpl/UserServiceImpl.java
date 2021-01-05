package org.zjy.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.dao.UserDao;
import org.zjy.entity.User;
import org.zjy.model.UserModel;
import org.zjy.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

/*    @Autowired
    private UserDao userDao;*/

    @Override
    public List<UserModel> getAllUser() {
        List<User> userEntityList = userDao.getAllUser();
        List<UserModel> userModelList = new ArrayList<>();
        for (User userEntity : userEntityList){
            UserModel userModel = new UserModel();
            userModel.setName(userEntity.getName());
            userModel.setId(userEntity.getId());
            userModel.setAge(userEntity.getAge());
            userModelList.add(userModel);
        }
        return userModelList;
//        return null;
    }

    @Override
    public void addUser(UserModel userModel) {
        User userEntity = new User();
        userEntity.setName(userModel.getName());
        userEntity.setAge(userModel.getAge());
        userEntity.setPassword(userModel.getPassword());
        userDao.addUser(userEntity);
    }

    @Override
    public UserModel getUserById(Integer id) {
        User userEntity = userDao.getUserById(id);
        UserModel userModel = new UserModel();
        userModel.setAge(userEntity.getAge());
        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setPassword(userEntity.getPassword());
        return userModel;
//        return null;
    }

    @Override
    public void updateUser(UserModel userModel) {
        User userEntity = userDao.getUserById(userModel.getId());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setAge(userModel.getAge());
        userEntity.setName(userModel.getName());
        userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUser(Integer[] ids) {
        for (Integer id : ids){
            userDao.deleteUserById(id);
        }
    }
}
