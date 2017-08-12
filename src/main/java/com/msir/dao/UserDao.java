package com.msir.dao;


import com.msir.pojo.UserDO;

import java.util.Set;

public interface UserDao {


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


    /**
     * 根据用户名查询用户相关信息
     * @param userName
     * @return
     */
    UserDO getUserInfoByUserName(String userName);
}
