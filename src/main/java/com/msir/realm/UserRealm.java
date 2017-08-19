package com.msir.realm;

import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by HSH on 2017/7/3.
 */
public class UserRealm extends AuthorizingRealm {
    private static Logger log = Logger.getLogger(AuthorizingRealm.class);

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * 为当前登录成功的用户授予角色和权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //AuthorizationInfo 封装了当前用户的角色与权限
        //PrincipalCollection 用户身份
        String userName = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        try {
            authorizationInfo.setRoles(userService.getUserRoles(userName));
            log.info("用户的角色：" + userService.getUserRoles(userName).toString());
            authorizationInfo.setStringPermissions(userService.getUserPermissions(userName));
            log.info("用户的权限：" + userService.getUserPermissions(userName).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    /**
     * 验证当前登录的用户
     * SimpleAuthenticationInfo的实现类，封装正确的用户名密码
     * AuthenticationToken 用户输入的用户名密码
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        UserDO user = userService.getUserInfoByUserName(userName);

        if (user != null) {
            //盐值加密
            ByteSource salt = ByteSource.Util.bytes(user.getUserLoginName());
            //SimpleAuthenticationInfo   salt是给AuthenticationToken中token用的，也就是前端用户输入的密码
            AuthenticationInfo authenticationInfoInfo = new SimpleAuthenticationInfo(user.getUserLoginName(), user.getUserPassword(), salt, "xx");
            return authenticationInfoInfo;
        }
        return null;
    }
}
