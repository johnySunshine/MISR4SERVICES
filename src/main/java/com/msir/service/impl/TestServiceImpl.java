package com.msir.service.impl;

import com.msir.dao.TestDao;
import com.msir.pojo.UserDO;
import com.msir.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("testService")
public class TestServiceImpl implements ITestService{
    @Autowired
    TestDao testMapper;

    public int query() {
        return testMapper.query();
    }

    public UserDO queryInfoByUsername(String userName) {
        return testMapper.queryInfoByUsername(userName);
    }


    /**
     * 获取用户的角色
     * @param userName
     * @return
     */
    public Set<String> getUserRoles(String userName) {
        return testMapper.getUserRoles(userName);
    }


    /**
     * 获取用户的权限
     * @param userName
     * @return
     */
    public Set<String> getUserPermissions(String userName) {
        return testMapper.getUserPermissions(userName);
    }
}
