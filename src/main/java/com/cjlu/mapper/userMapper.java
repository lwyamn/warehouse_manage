package com.cjlu.mapper;

import com.cjlu.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface userMapper {
    //查找用户信息
    user queryUserMsg(String userID);
}
