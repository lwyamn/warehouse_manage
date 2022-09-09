package com.cjlu.controller.mp;

import com.cjlu.pojo.user;
import com.cjlu.service.userService;
import com.cjlu.util.R;
import com.cjlu.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/loginMP")
@Api(value = "登录手机端Controller",tags   = {"登录手机端访问接口"})
public class loginController {

    @Autowired
    private userService userService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public R login(String userID,String password){
        user user = userService.queryUserMsg(userID);
        if(user==null){
            return R.error("账号错误");
        }else if(!password.equals(user.getPassword())){
            return R.error("密码错误");
        }else {
            String token= UUID.randomUUID().toString().replaceAll("-","");
            redisUtil.set(token,userID,1);
            return R.success("登录成功").add("token",token);
        }
    }

    @PostMapping("/logout")
    public R<String> logout(@RequestHeader("token")String token){
        redisUtil.del(token);
        return R.success("注销成功");
    }
}
