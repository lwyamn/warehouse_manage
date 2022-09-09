package com.cjlu.service.impl;

import com.cjlu.mapper.logMapper;
import com.cjlu.pojo.log;
import com.cjlu.service.logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class logServiceImpl implements logService {

    @Autowired
    private logMapper logMapper;


    @Override
    public List<log> queryLogPaging(int currPage, int pageSize) {
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return logMapper.queryLogPaging(page);
    }
}
