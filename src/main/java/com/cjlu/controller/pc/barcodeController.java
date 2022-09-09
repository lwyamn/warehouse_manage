package com.cjlu.controller.pc;

import com.cjlu.config.logAnnotation;
import com.cjlu.service.barcodeService;
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
@RequestMapping("/barcode")
@Api(value = "生成条形码电脑端Controller",tags = {"条形码生成"})
public class barcodeController {
    @Autowired
    private barcodeService barcodeService;

    @GetMapping("/create/{msg}")
    @ApiOperation(value = "生成条形码")
    @logAnnotation(action = "生成条形码",methodDesc = "条形码",systemType = "PC",actionType = "生成")
    public R<String> createBarcode(@ApiParam("信息") @PathVariable("msg") String msg){
        return barcodeService.createBarcode(msg);
    }
}
