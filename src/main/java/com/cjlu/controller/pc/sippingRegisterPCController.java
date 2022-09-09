package com.cjlu.controller.pc;

import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.inkLocationStockGL;
import com.cjlu.service.sippingRegisterService;
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
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/sippingRegisterPC")
@Api(value = "发货登记单电脑端Controller",tags = {"发货登记单访问接口"})
public class sippingRegisterPCController {
    @Autowired
    private sippingRegisterService sippingRegisterService;

    @GetMapping("/querySippingRegisterPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "配货单查询并分页")
    @logAnnotation(action = "获取配货单",methodDesc = "配货单",systemType = "PC",actionType = "查询")
    public R<List<Map<String,Object>>> querySippingRegisterPaging(@ApiParam("页数") @PathVariable("currPage") int currPage, @ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(sippingRegisterService.querySippingRegisterPaging(currPage,pageSize));
    }

    @GetMapping("/deleteSippingRegister/{purchaseID}")
    @ApiOperation(value = "配货单删除")
    @logAnnotation(action = "删除出库单",methodDesc = "配货单",systemType = "PC",actionType = "删除")
    public R<String> deleteSippingRegister(@ApiParam("单据流水号") @PathVariable("purchaseID") int purchaseID){
        return sippingRegisterService.deleteSippingRegister(purchaseID);
    }


}
