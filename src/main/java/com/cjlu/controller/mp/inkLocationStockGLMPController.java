package com.cjlu.controller.mp;


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

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/inkLocationStockGLMP")
@Api(value = "墨水区手机端Controller",tags   = {"墨水区访问接口"})
public class inkLocationStockGLMPController {
    @Autowired
     private inkLocationStockGLService inkLocationStockGLService;

    @PostMapping("/addAndUpdate")
    @ApiOperation(value = "入库的添加或更新")
    @logAnnotation(action = "添加或者更新墨水区",methodDesc = "墨水区",systemType = "手机web",actionType = "插入或更新")
    public R<String> addAndUpdateInk(@ApiParam("墨水区位库存总账") @RequestBody inkLocationStockGL locationStock){
        return inkLocationStockGLService.addAndUpdateInkLocationStock(locationStock);
    }

    @PostMapping("/getFinalNumber")
    @ApiOperation(value = "查找期末数量")
    @logAnnotation(action = "查找期末数量",methodDesc = "墨水区",systemType = "手机web",actionType = "查询")
    public R<Map<String,Integer>> getFinalNumber(@ApiParam("墨水区位库存总账") @RequestBody inkLocationStockGL locationStock){
        Map<String,Integer> map = inkLocationStockGLService.getFinalNumber(locationStock);
        if(map==null)
        {
            return R.error("没有找到该月的期末数量");
        }
        return R.success(inkLocationStockGLService.getFinalNumber(locationStock));
    }
    @PostMapping("/UpdateS")
    @ApiOperation(value = "确认发货更新")
    @logAnnotation(action = "确认发货进行更新",methodDesc = "墨水区",systemType = "手机web",actionType = "更新")
    public R<String> updateInkLocationStockS(@ApiParam("墨水区位库存总账Map") @RequestBody Map<String,Object> locationStockMap){
        inkLocationStockGLService.updateInkLocationStockS(locationStockMap);
        return R.success("修改成功");

    }


}
