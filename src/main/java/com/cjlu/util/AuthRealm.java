package com.cjlu.util;

import com.cjlu.pojo.user;
import com.cjlu.service.userService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private userService userService;

    @Autowired
    private RedisUtil redisUtil;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取前端传来的token
        String accessToken= (String) token.getPrincipal();

        //redis缓存中这样存值， key为token，value为username
        //根据token去缓存里查找用户名
        String userID = (String) redisUtil.get(accessToken);
        if(userID==null){
            //查找的用户名为空，即为token失效
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        user user = userService.queryUserMsg(userID);
        if(user==null){
            throw new UnknownAccountException("用户不存在!");
        }

        if(user.getUnUsed()==1){
            throw new UnknownAccountException("该用户已停用!");
        }

        //此方法需要返回一个AuthenticationInfo类型的数据
        // 因此返回一个它的实现类SimpleAuthenticationInfo,将user以及获取到的token传入它可以实现自动认证
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user,accessToken,"");
        return simpleAuthenticationInfo;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从认证那里获取到用户对象User
        user user = (user) principals.getPrimaryPrincipal();

        //此方法需要一个AuthorizationInfo类型的返回值，因此返回一个它的实现类SimpleAuthorizationInfo
        //通过SimpleAuthorizationInfo里的addStringPermission()设置用户的权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (user.getIsAdministrator() == 1) {
            simpleAuthorizationInfo.addStringPermission("admin");
            simpleAuthorizationInfo.addStringPermission("auth");
        } else {
            simpleAuthorizationInfo.addStringPermission("staff");
        }
        return simpleAuthorizationInfo;
    }
    }