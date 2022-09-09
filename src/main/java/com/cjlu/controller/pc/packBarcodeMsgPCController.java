package com.cjlu.controller.pc;

import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.inkLocationStockGL;
import com.cjlu.pojo.packBarcodeMsg;
import com.cjlu.service.packBarcodeMsgService;
import com.cjlu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/packBarcodeMsgPC")
@Api(value = "条码信息电脑端Controller",tags = {"条码信息访问接口"})
public class packBarcodeMsgPCController {

    @Autowired
    private packBarcodeMsgService packBarcodeMsgService;

    @GetMapping("/queryMsgPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "条码查询并分页")
    @logAnnotation(action = "获取条码信息",methodDesc = "条码信息",systemType = "PC",actionType = "查询")
    public R<List<packBarcodeMsg>> queryMsgPaging(@ApiParam("页数") @PathVariable("currPage") int currPage, @ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(packBarcodeMsgService.queryMsgPaging(currPage,pageSize));
    }

    @PostMapping("/addMsg")
    @ApiOperation(value = "条码区添加条码")
    @logAnnotation(action = "添加条码信息",methodDesc = "条码信息",systemType = "PC",actionType = "插入")
    public R<String> addMsg(@ApiParam("条码") @RequestBody packBarcodeMsg msg){
        return packBarcodeMsgService.addPackBarcodeMsg(msg);
    }

    @PostMapping("/updatePackBarcodeMsg")
    @ApiOperation(value = "条码更新记录")
    @logAnnotation(action = "更新条码信息",methodDesc = "条码信息",systemType = "PC",actionType = "更新")
    public R<String> updatePackBarcodeMsg(@ApiParam("条码") @RequestBody packBarcodeMsg msg){
        return packBarcodeMsgService.updatePackBarcodeMsg(msg);
    }

    @GetMapping("/deletePackBarcodeMsg/{serialID}")
    @ApiOperation(value = "条码删除")
    @logAnnotation(action = "删除条码信息",methodDesc = "条码信息",systemType = "PC",actionType = "删除")
    public R<String> deletePackBarcodeMsg(@ApiParam("流水号") @PathVariable("serialID") int serialID){
        return packBarcodeMsgService.deletePackBarcodeMsg(serialID);
    }
}
