package com.cjlu.service;

import com.cjlu.util.R;

public interface barcodeService {
    //生成该信息条形码
    R<String> createBarcode(String msg);
}
