package com.msir.service;

import com.msir.pojo.UserDO;

import java.util.List;
import java.util.Set;

/**
 * Created by Fantasy on 2017/6/8.
 *
 */
public interface UserService {

    List<UserDO> listUser();
    /**
     * 根据用户名查询用户相关信息
     * @param userName
     * @return
     */
    UserDO getUserInfoByUserName(String userName);


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


    int saveUserInfo(UserDO userDO);

    int removeUser(int userId);
    int updateUser(UserDO userDO);
}
