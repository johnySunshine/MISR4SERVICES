package com.msir.shiro;

import com.msir.pojo.UserDO;
import com.msir.service.ITestService;
import com.msir.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by HSH on 2017/7/3.
 */
public class ShiroRealm extends AuthorizingRealm {
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
        UserDO user = userService.queryInfoByUsername(userName);

        if (user != null) {
            //盐值加密
            ByteSource salt = ByteSource.Util.bytes(user.getUserName());
            //数据库目前存的是明文，所以用md5加密转换
            SimpleHash sh = new SimpleHash("md5", user.getUserPassword(), salt, 2);
            SimpleHash sh1 = new SimpleHash("md5", user.getUserPassword(), null, 2);
            //SimpleAuthenticationInfo   salt是给AuthenticationToken中token用的，也就是前端用户输入的密码
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), sh, salt, "xx");
            return authcInfo;
        }
        return null;
    }
}
