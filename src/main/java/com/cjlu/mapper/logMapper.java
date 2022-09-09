package com.cjlu.mapper;

import com.cjlu.pojo.log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface logMapper {
    //插入日志
    int addLog(log log);
    //查询日志并分页
    List<log> queryLogPaging(Map<String,Object> page);
}
