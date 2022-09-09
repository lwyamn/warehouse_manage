package com.cjlu.controller.pc;


import com.cjlu.config.logAnnotation;
import com.cjlu.service.finalProductStockInService;
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
@RequestMapping("/finalProductStockInPC")
@Api(value = "产成品入库单电脑端Controller",tags = {"访问接口产成品入库单"})
public class finalProductStockInPCController {
    @Autowired
    private finalProductStockInService finalProductStockInService;

    @GetMapping("/queryStockInPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "入库登记单查询并分页")
    @logAnnotation(action = "获取入库登记单",methodDesc = "入库登记单",systemType = "PC",actionType = "查询")
    public R<List<Map<String,Object>>> queryStockInPaging(@ApiParam("页数") @PathVariable("currPage") int currPage, @ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(finalProductStockInService.queryStockInPaging(currPage,pageSize));
    }

    @GetMapping("/deleteStockIn/{purchaseID}/{documentsTbodyID}")
    @ApiOperation(value = "删除入库登记单")
    @logAnnotation(action = "删除入库登记单",methodDesc = "入库登记单",systemType = "PC",actionType = "删除")
    public R<String> deleteStockIn(@ApiParam("单据流水号") @PathVariable("purchaseID") int purchaseID,@ApiParam("单据表体号") @PathVariable("documentsTbodyID") int documentsTbodyID){
        return finalProductStockInService.deleteStockIn(purchaseID,documentsTbodyID);
    }

    @PostMapping("/updateStockIn")
    @ApiOperation(value = "修改入库登记单")
    @logAnnotation(action = "修改入库登记单",methodDesc = "入库登记单",systemType = "PC",actionType = "修改")
    public R<String> updateStockIn(@ApiParam("入库登记单map") @RequestBody Map<String,Object> product){
        return finalProductStockInService.updateStockInAll(product);
    }

    @PostMapping("/addAllJOG")
    @ApiOperation(value = "添加入库登记单")
    @logAnnotation(action = "添加入库登记单",methodDesc = "入库登记单",systemType = "PC",actionType = "添加")
    public R<String> addAllJOG(@ApiParam("入库登记单map") @RequestBody Map<String,Object> product){
        return finalProductStockInService.addProductToAllJOG(product);
    }



}
