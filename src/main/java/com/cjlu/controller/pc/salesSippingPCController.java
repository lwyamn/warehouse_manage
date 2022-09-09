package com.cjlu.controller.pc;

import com.cjlu.config.logAnnotation;
import com.cjlu.service.salesSippingService;
import com.cjlu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/salesSippingPC")
@Api(value = "出库登记单电脑端Controller",tags = {"出库登记单访问接口"})
public class salesSippingPCController {

    @Autowired
    private salesSippingService salesSippingService;

    @GetMapping("/querySalesSippingPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "出库单查询并分页")
    @logAnnotation(action = "获取出库单",methodDesc = "出库单",systemType = "PC",actionType = "查询")
    public R<List<Map<String,Object>>> querySalesSippingPaging(@ApiParam("页数") @PathVariable("currPage") int currPage, @ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(salesSippingService.querySalesSippingPaging(currPage,pageSize));
    }

    @GetMapping("/deleteSalesSipping/{purchaseID}/{documentsTbodyID}")
    @ApiOperation(value = "删除出库登记单")
    @logAnnotation(action = "删除出库登记单",methodDesc = "出库单",systemType = "PC",actionType = "删除")
    public R<String> deleteSalesSipping(@ApiParam("单据流水号") @PathVariable("purchaseID") int purchaseID,@ApiParam("单据表体号") @PathVariable("documentsTbodyID") int documentsTbodyID){
        return salesSippingService.deleteSalesSipping(purchaseID,documentsTbodyID);
    }

    @PostMapping("/updateSalesSipping")
    @ApiOperation(value = "修改出库登记单")
    @logAnnotation(action = "修改出库登记单",methodDesc = "出库单",systemType = "PC",actionType = "修改")
    public R<String> updateSalesSipping(@ApiParam("出库登记单map") @RequestBody Map<String,Object> salesSipping){
        return salesSippingService.updateSalesSipping(salesSipping);
    }
}
