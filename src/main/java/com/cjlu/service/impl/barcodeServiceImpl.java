package com.cjlu.service.impl;

import com.cjlu.service.barcodeService;
import com.cjlu.util.BarcodeUtils;
import com.cjlu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class barcodeServiceImpl implements barcodeService {
    @Autowired
    private BarcodeUtils barcodeUtils;


    @Override
    public R<String> createBarcode(String msg) {

        String userDir = System.getProperties().getProperty("user.dir");
        String fileSeparator = File.separator;
        String path = userDir+fileSeparator+"images"+fileSeparator+msg+".png";
        barcodeUtils.generateFile(msg,path);
        return R.success("http://121.36.104.226:8080/images/"+msg+".png");
    }
}
