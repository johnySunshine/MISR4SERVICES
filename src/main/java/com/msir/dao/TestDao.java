package com.msir.dao;

import com.msir.pojo.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by HSH on 2017/7/10.
 */
@Repository
public interface TestDao {
    int query();

    UserDO queryInfoByUsername(@Param(value = "userName")String userName);


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
