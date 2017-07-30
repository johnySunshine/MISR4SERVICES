package com.msir.service.impl;

import com.msir.dao.UserDao;
import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Fantasy on 2017/6/8.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserDO getUserInfo(String userName) {
        return userDao.getUserInfo(userName);
    }


    /**
     * 根据用户名查询用户相关信息
     * @param userName
     * @return
     */
    public UserDO queryInfoByUsername(String userName) {
        return userDao.queryInfoByUsername(userName);
    }


    /**
     * 获取用户的角色
     * @param userName
     * @return
     */
    public Set<String> getUserRoles(String userName) {
        return userDao.getUserRoles(userName);
    }


    /**
     * 获取用户的权限
     * @param userName
     * @return
     */
    public Set<String> getUserPermissions(String userName) {
        return userDao.getUserPermissions(userName);
    }
}
