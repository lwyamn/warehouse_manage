package com.cjlu.service.impl;

import com.cjlu.mapper.userMapper;
import com.cjlu.pojo.user;
import com.cjlu.service.userService;
import com.cjlu.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;


    @Override
    public user queryUserMsg(String userID) {
        return userMapper.queryUserMsg(userID);
    }
}
