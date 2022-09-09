package com.cjlu.service;

import com.cjlu.pojo.packBarcodeMsg;
import com.cjlu.util.R;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface packBarcodeMsgService {
    packBarcodeMsg getTaskList(int serialID);
    R<String> updateStockInNumber(int serialID, BigDecimal stockInNumber);
    List<packBarcodeMsg> queryMsgPaging(int currPage,int pageSize);
    R<String> addPackBarcodeMsg(packBarcodeMsg msg);
    R<String> updatePackBarcodeMsg(packBarcodeMsg msg);
    R<String> deletePackBarcodeMsg(int serialID);
}
