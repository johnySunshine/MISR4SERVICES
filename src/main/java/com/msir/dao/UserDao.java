package com.msir.dao;


import com.msir.pojo.UserDO;

import java.util.List;
import java.util.Set;

public interface UserDao {

    List<UserDO> listUser();

    /**
     * 获取用户的角色
     *
     * @param userName
     * @return
     */
    Set<String> getUserRoles(String userName);


    /**
     * 获取用户的权限
     *
     * @param userName
     * @return
     */
    Set<String> getUserPermissions(String userName);


    /**
     * 根据用户名查询用户相关信息
     *
     * @param userName
     * @return
     */
    UserDO getUserInfoByUserName(String userName);

    /**
     * 新增用户
     *
     * @param userDO
     * @return
     */
    int saveUserInfo(UserDO userDO);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int removeUser(int userId);

    /**
     * 更新用户
     *
     * @param userDO
     * @return
     */
    int updateUser(UserDO userDO);
}
