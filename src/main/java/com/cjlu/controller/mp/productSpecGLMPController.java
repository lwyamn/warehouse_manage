package com.cjlu.controller.mp;


import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.productSpecGL;
import com.cjlu.service.productSpecGLService;
import com.cjlu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/productSpecGLMP")
@Api(value = "规格总账手机端Controller",tags = {"规格总账访问接口"})
public class productSpecGLMPController {
    @Autowired
    private productSpecGLService productSpecGLService;

    @PostMapping("/addProductSpec")
    @ApiOperation(value = "产品规格总账中插入库数据")
    @logAnnotation(action = "插入入库数据",methodDesc = "产品规格总账",systemType = "手机web",actionType = "插入")
    public R<String> addProductSpec(@ApiParam("产品规格") @RequestBody productSpecGL productSpec){
        productSpecGLService.addProductSpec(productSpec);
        return R.success("插入入库数据成功");
    }
    @PostMapping("/getFinalNumber")
    @ApiOperation(value = "产品规格总账中获取期末数量")
    @logAnnotation(action = "获取期末数量",methodDesc = "产品规格总账",systemType = "手机web",actionType = "查询")
    public R<Map<String,Integer>> getFinalNumber(@ApiParam("产品规格") @RequestBody productSpecGL productSpec){
        Map<String,Integer> map = productSpecGLService.getFinalNumber(productSpec);
        if(map==null)
        {
            return R.error("没有找到期末数量");
        }
        return R.success(productSpecGLService.getFinalNumber(productSpec));
    }
    @PostMapping("/updateFN")
    @ApiOperation(value = "更新产品规格总账中期末数量")
    @logAnnotation(action = "更新期末数量",methodDesc = "产品规格总账",systemType = "手机web",actionType = "更新")
    public R<String> updateFN(@ApiParam("产品规格Map") @RequestBody Map<String,Object> productSpec){
        productSpecGLService.updateProductSpecFN(productSpec);
        return R.success("更新成功");
    }
}
