package com.cjlu.controller.pc;


import com.cjlu.pojo.log;
import com.cjlu.service.logService;
import com.cjlu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/logPC")
@Api(value = "日志电脑端Controller",tags   = {"日志访问接口"})
public class logController {
    @Autowired
    private logService logService;

    @GetMapping("/queryLogPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "日志查询并分页")
    public R<List<log>> queryLogPaging(@ApiParam("页数") @PathVariable("currPage") int currPage, @ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(logService.queryLogPaging(currPage,pageSize));
    }
}
