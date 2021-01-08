package org.zjy.serviceImpl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.dao.TUserMapper;
import org.zjy.entity.TUser;
import org.zjy.model.UserModel;
import org.zjy.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Service
@DubboService(version = "1.0.0", protocol = {"dubbo"})
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

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
    public Boolean addUser(UserModel userModel) {
        TUser userEntity = new TUser();
        userEntity.setName(userModel.getName());
        userEntity.setAge(userModel.getAge());
        userEntity.setPassword(userModel.getPassword());
        Integer result = userMapper.insert(userEntity);
        return 1 == result ? true : false;
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
    public Boolean updateUser(UserModel userModel) {
        TUser userEntity = userMapper.selectByPrimaryKey(userModel.getId());
        //userDao.getUserById(userModel.getId());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setAge(userModel.getAge());
        userEntity.setName(userModel.getName());
        Integer result = userMapper.updateByPrimaryKey(userEntity);
        return 1 == result ? true : false;
        //userDao.updateUser(userEntity);
    }

    @Override
    public Boolean deleteUser(Integer[] ids) {
        Integer result = null;
        for (Integer id : ids){
            result = userMapper.deleteByPrimaryKey(id);
            if (result == 0){
                break;
            }
            //userDao.deleteUserById(id);
        }
        return 1 == result ? true : false;

    }
}
