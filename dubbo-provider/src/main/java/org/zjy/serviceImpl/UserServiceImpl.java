package org.zjy.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.dao.TUserMapper;
import org.zjy.entity.TUser;
//import org.zjy.entity.User;
import org.zjy.model.UserModel;
import org.zjy.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

/*    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

/*    @Autowired
    private UserDao userDao;*/

    @Override
    public List<UserModel> getAllUser() {
        List<TUser> userEntityList = userMapper.selectByExample(null);
        List<UserModel> userModelList = new ArrayList<>();
        for (TUser userEntity : userEntityList){
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
        TUser userEntity = new TUser();
        userEntity.setName(userModel.getName());
        userEntity.setAge(userModel.getAge());
        userEntity.setPassword(userModel.getPassword());
        userMapper.insert(userEntity);
        //userDao.addUser(userEntity);
    }

    @Override
    public UserModel getUserById(Integer id) {
        TUser userEntity = userMapper.selectByPrimaryKey(id);
        //userDao.getUserById(id);
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
        TUser userEntity = userMapper.selectByPrimaryKey(userModel.getId());
        //userDao.getUserById(userModel.getId());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setAge(userModel.getAge());
        userEntity.setName(userModel.getName());
        userMapper.updateByPrimaryKey(userEntity);
        //userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUser(Integer[] ids) {
        for (Integer id : ids){
            userMapper.deleteByPrimaryKey(id);
            //userDao.deleteUserById(id);
        }
    }
}
