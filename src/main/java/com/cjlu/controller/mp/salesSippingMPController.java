package com.cjlu.controller.mp;


import com.cjlu.config.logAnnotation;
import com.cjlu.service.salesSippingService;
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
@RequestMapping("/salesSippingMP")
@Api(value = "销售发货手机端Controller",tags = {"销售发货访问接口"})
public class salesSippingMPController {

    @Autowired
    private salesSippingService salesSippingService;

    @PostMapping("/addHeader")
    @ApiOperation(value = "发货单插入表头")
    @logAnnotation(action = "插入表头",methodDesc = "出库单",systemType = "手机web",actionType = "插入")
    public R<String> addHeader(@ApiParam("发货销售表Map") @RequestBody Map<String, Object> sippingHeader){
        return R.success(salesSippingService.addProductToHeader(sippingHeader));
    }
    @GetMapping("/endAdd/{registerID}")
    @ApiOperation(value = "结束添加")
    @logAnnotation(action = "结束添加",methodDesc = "出库单",systemType = "手机web",actionType = "停止")
    public R<String> endAdd(@ApiParam("登记单号") @PathVariable("registerID") String registerID){
        return R.success(salesSippingService.endProductAdd(registerID));
    }

    @PostMapping("/addTbodyAndSun")
    @ApiOperation(value = "发货单插入表孙表体")
    @logAnnotation(action = "插入孙体表体",methodDesc = "出库单",systemType = "手机web",actionType = "插入")
    public R<String> addTbodyAndSun(@ApiParam("发货销售表Map") @RequestBody Map<String, Object> sippingHeader){
        return R.success(salesSippingService.addProductToTbodyAndSun(sippingHeader));
    }
}
