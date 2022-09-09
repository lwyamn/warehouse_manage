package com.cjlu.controller.pc;

import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.inkLocationStockGL;
import com.cjlu.service.inkLocationStockGLService;
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
@RequestMapping("/inkLocationStockGLPC")
@Api(value = "墨水区电脑端Controller",tags   = {"墨水区访问接口"})
public class inkLocationStockGLPCController {

    @Autowired
    private inkLocationStockGLService inkLocationStockGLService;

    @GetMapping("/queryGLPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "墨水区查询并分页")
    @logAnnotation(action = "获取墨水区",methodDesc = "墨水区",systemType = "PC",actionType = "查询")
    public R<List<inkLocationStockGL>> queryGLPaging(@ApiParam("页数") @PathVariable("currPage") int currPage,@ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(inkLocationStockGLService.queryGLPaging(currPage,pageSize));
    }

    @GetMapping("/deleteGL/{purchaseID}")
    @ApiOperation(value = "墨水区删除记录")
    @logAnnotation(action = "删除墨水区记录",methodDesc = "墨水区",systemType = "PC",actionType = "删除")
    public R<String> deleteGL(@ApiParam("单据流水号") @PathVariable("purchaseID") int purchaseID){
        return inkLocationStockGLService.deleteGL(purchaseID);
    }

    @PostMapping("/updateGL")
    @ApiOperation(value = "墨水区更新记录")
    @logAnnotation(action = "修改墨水区记录",methodDesc = "墨水区",systemType = "PC",actionType = "修改")
    public R<String> updateGL(@ApiParam("墨水区") @RequestBody inkLocationStockGL locationStockGL){
        return inkLocationStockGLService.updateGL(locationStockGL);
    }

    @PostMapping("/addGL")
    @ApiOperation(value = "墨水区添加记录")
    @logAnnotation(action = "添加墨水区记录",methodDesc = "墨水区",systemType = "PC",actionType = "添加")
    public R<String> addGL(@ApiParam("墨水区") @RequestBody inkLocationStockGL locationStockGL){
        return inkLocationStockGLService.addInkLocationStock(locationStockGL);
    }
}
