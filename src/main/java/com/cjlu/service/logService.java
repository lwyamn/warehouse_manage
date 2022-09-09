package com.cjlu.service;

import com.cjlu.pojo.log;

import java.util.List;

public interface logService {
    List<log> queryLogPaging(int currPage,int pageSize);
}
