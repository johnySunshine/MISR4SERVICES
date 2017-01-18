package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.IUserDao;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.IUserService;
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
