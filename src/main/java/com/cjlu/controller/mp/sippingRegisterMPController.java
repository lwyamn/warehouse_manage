package com.cjlu.controller.mp;

import com.cjlu.config.logAnnotation;
import com.cjlu.pojo.sippingRegisterHeader;
import com.cjlu.pojo.sippingRegisterTbody;
import com.cjlu.service.sippingRegisterService;
import com.cjlu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/sippingRegisterMP")
@Api(value = "发货登记单手机端Controller",tags = {"发货登记单访问接口"})
public class sippingRegisterMPController {

    @Autowired
    private sippingRegisterService sippingRegisterService;

    @GetMapping("/getHeader/{registerID}")
    @ApiOperation(value = "通过登记单号获取配货内容")
    @logAnnotation(action = "获取配货内容表头",methodDesc = "配货单",systemType = "手机web",actionType = "查询")
    public R<sippingRegisterHeader> getHeader(@PathVariable("registerID") @ApiParam("登记单号") String registerID){
        sippingRegisterHeader sippingRegisterHeader = sippingRegisterService.getSippingRegisterHeader(registerID);
        if (sippingRegisterHeader==null){
            return R.error("没有找到对应的登记单号");
        }
        return R.success(sippingRegisterHeader);
    }

    @GetMapping("/getTbody/{purchaseID}")
    @ApiOperation(value = "通过单据流水号获取发货产品内容")
    @logAnnotation(action = "获取配货内容表体",methodDesc = "配货单",systemType = "手机web",actionType = "查询")
    public R<List<sippingRegisterTbody>> getTbody(@PathVariable("purchaseID") @ApiParam("单据流水号") int purchaseID){
        List<sippingRegisterTbody> sippingRegisterTbody = sippingRegisterService.getSippingRegisterTbody(purchaseID);
        if (sippingRegisterTbody==null){
            return R.error("没有找到对应的产品内容");
        }
        return R.success(sippingRegisterTbody);
    }
    @PostMapping("/updateTbody/updateSN")
    @ApiOperation(value = "修改配货单的已发数量")
    @logAnnotation(action = "修改已发数量",methodDesc = "配货单",systemType = "手机web",actionType = "修改")
    public R<String> updateTbodySN(@RequestBody @ApiParam("配货Map")Map<String,Object> sippingRegister){
        sippingRegisterService.updateSippingRegisterTbodySN(sippingRegister);
        return R.success("更新成功");
    }

}
