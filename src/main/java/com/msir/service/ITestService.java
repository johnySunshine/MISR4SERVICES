package com.msir.service;

import com.msir.pojo.UserDO;

import java.util.Set;

/**
 * Created by HSH on 2017/7/10.
 */
public interface ITestService {
    int query();

    UserDO queryInfoByUsername(String userName);


    /**
     * 获取用户的角色
     * @param userName
     * @return
     */
    Set<String> getUserRoles(String userName);


    /**
     * 获取用户的权限
     * @param userName
     * @return
     */
    Set<String> getUserPermissions(String userName);
}
