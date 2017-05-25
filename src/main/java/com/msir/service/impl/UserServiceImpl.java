package com.msir.service.impl;

import com.msir.dao.IUserDao;
import com.msir.pojo.User;
import com.msir.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;

    public User getUserInfo(String userName) {
        return userDao.getUserInfo(userName);
    }
}
