package com.cjlu.controller.mp;


import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.packBarcodeMsg;
import com.cjlu.service.packBarcodeMsgService;
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

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/packBarcodeMsgMP")
@Api(value = "条码信息手机端Controller",tags = {"条码信息访问接口"})
public class packBarcodeMsgMPController {
    @Autowired
    private packBarcodeMsgService packBarcodeMsgService;

    @GetMapping("/getTaskList/{serialID}")
    @ApiOperation(value = "通过流水号获取任务单")
    @logAnnotation(action = "获取任务单",methodDesc = "条码信息",systemType = "手机web",actionType = "查询")
    public R<packBarcodeMsg> getTaskList(@PathVariable("serialID") @ApiParam("流水号") int serialID){
        packBarcodeMsg taskList = packBarcodeMsgService.getTaskList(serialID);
        if (taskList==null){
            return R.error("没有找到对应流水号");
        }
        return R.success(taskList);
    }
    @GetMapping("/updateStockInNumber/{serialID}/{stockInNumber}")
    @ApiOperation(value = "通过流水号修改入库数量")
    @logAnnotation(action = "修改入库数量",methodDesc = "条码信息",systemType = "手机web",actionType = "修改")
    public R<String> updateStockInNumber(@PathVariable("serialID") @ApiParam("流水号") int serialID,@PathVariable("stockInNumber") @ApiParam("入库数量") BigDecimal stockInNumber){
        return packBarcodeMsgService.updateStockInNumber(serialID,stockInNumber);
    }
}
