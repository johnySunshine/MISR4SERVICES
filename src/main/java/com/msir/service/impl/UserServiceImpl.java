package com.msir.service.impl;

import com.msir.dao.UserDao;
import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Fantasy on 2017/6/8.
 *
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserDO getUserInfo(String userName) {
        return userDao.getUserInfo(userName);
    }
}
