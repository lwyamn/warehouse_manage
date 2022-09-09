package com.cjlu.controller.mp;


import com.cjlu.config.logAnnotation;
import com.cjlu.service.finalProductStockInService;
import com.cjlu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/finalProductStockInMP")
@Api(value = "产成品入库单手机端Controller",tags = {"访问接口产成品入库单"})
public class finalProductStockInMPController {
    @Autowired
    private finalProductStockInService finalProductStockInService;

    @PostMapping("/addHeader")
    @ApiOperation(value = "添加表头")
    @logAnnotation(action = "添加表头",methodDesc = "入库表头",systemType = "手机web",actionType = "插入")
    public R<String> addHeader(@ApiParam("产成品入库单Map") @RequestBody Map<String,Object> product){
        return finalProductStockInService.addProductToHeader(product);
    }

    @GetMapping("/endAdd/{lot}")
    @ApiOperation(value = "结束添加")
    @logAnnotation(action = "停止添加",methodDesc = "结束入库",systemType = "手机web",actionType = "停止")
    public R<String> endAdd(@ApiParam("批次号") @PathVariable("lot") String lot){
        return finalProductStockInService.endProductAdd(lot);
    }

    @PostMapping("/addTbodyAndSun")
    @ApiOperation(value = "添加表孙表体")
    @logAnnotation(action = "添加表孙表体",methodDesc = "入库表孙表体",systemType = "手机web",actionType = "插入")
    public R<String> addTbodyAndSun(@ApiParam("产成品入库单Map") @RequestBody Map<String,Object> product){
        return finalProductStockInService.addProductToTbodyAndSun(product);
    }

}
