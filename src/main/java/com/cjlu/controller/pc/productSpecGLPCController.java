package com.cjlu.controller.pc;

import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.packBarcodeMsg;
import com.cjlu.pojo.productSpecGL;
import com.cjlu.service.productSpecGLService;
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
@RequestMapping("/productSpecGLPC")
@Api(value = "规格总账电脑端Controller",tags = {"规格总账访问接口"})
public class productSpecGLPCController {

    @Autowired
    private productSpecGLService productSpecGLService;

    @GetMapping("/querySpecPaging/{currPage}/{pageSize}")
    @ApiOperation(value = "产品规格查询并分页")
    @logAnnotation(action = "获取产品规格总账",methodDesc = "产品规格总账",systemType = "PC",actionType = "查询")
    public R<List<productSpecGL>> querySpecPaging(@ApiParam("页数") @PathVariable("currPage") int currPage, @ApiParam("页长") @PathVariable("pageSize") int pageSize){
        return R.success(productSpecGLService.querySpecPaging(currPage,pageSize));
    }

    @PostMapping("/updateProductSpec")
    @ApiOperation(value = "产品规格更新记录")
    @logAnnotation(action = "更新产品规格总账",methodDesc = "产品规格总账",systemType = "PC",actionType = "更新")
    public R<String> updateProductSpec(@ApiParam("产品规格") @RequestBody productSpecGL productSpec){
        return productSpecGLService.updateProductSpec(productSpec);
    }

    @GetMapping("/deleteProductSpec/{purchaseID}")
    @ApiOperation(value = "产品规格总账删除")
    @logAnnotation(action = "删除产品规格总账",methodDesc = "产品规格总账",systemType = "PC",actionType = "删除")
    public R<String> deletePackBarcodeMsg(@ApiParam("单据流水号") @PathVariable("purchaseID") int purchaseID){
        return productSpecGLService.deleteProductSpec(purchaseID);
    }

    @PostMapping("/addProductSpecJOG")
    @ApiOperation(value = "添加产品规格总账")
    @logAnnotation(action = "添加产品规格总账",methodDesc = "产品规格总账",systemType = "PC",actionType = "插入")
    public R<String> addProductSpecJOG(@ApiParam("条码") @RequestBody productSpecGL productSpec){
        return productSpecGLService.addProductSpecJOG(productSpec);
    }

}
