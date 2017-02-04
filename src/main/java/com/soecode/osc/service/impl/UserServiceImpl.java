package com.soecode.osc.service.impl;

import com.soecode.osc.dao.IUserDao;
import com.soecode.osc.entity.User;
import com.soecode.osc.service.IUserService;
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
