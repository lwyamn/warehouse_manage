package com.cjlu.service.impl;

import com.cjlu.mapper.packBarcodeMsgMapper;
import com.cjlu.pojo.packBarcodeMsg;
import com.cjlu.service.packBarcodeMsgService;
import com.cjlu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class packBarcodeMsgServiceImpl implements packBarcodeMsgService {

    @Autowired
    private packBarcodeMsgMapper packBarcodeMsgMapper;

    static ExecutorService executorService = Executors.newFixedThreadPool(1);
    @Override
    public packBarcodeMsg getTaskList(int serialID) {
        return packBarcodeMsgMapper.getTaskList(serialID);
    }
    @Override
    public R<String> updateStockInNumber(int serialID,BigDecimal stockInNumber){
        packBarcodeMsg msg = new packBarcodeMsg();
        msg.setSerialID(serialID);
        msg.setStockInNumber(stockInNumber);
        try {
            System.out.println(msg);
            packBarcodeMsgMapper.updatePackBarcodeMsg(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("更新失败");
        }
        return R.success("更新成功");
    }

    @Override
    public List<packBarcodeMsg> queryMsgPaging(int currPage, int pageSize) {
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return packBarcodeMsgMapper.queryMsgPaging(page);
    }

    @Override
    public R<String> addPackBarcodeMsg(packBarcodeMsg msg) {
        try{
            packBarcodeMsgMapper.addPackBarcodeMsg(msg);
        }catch (Exception e){
            return R.error("添加失败");
        }
        return R.success("添加成功");
    }

    @Override
    public R<String> updatePackBarcodeMsg(packBarcodeMsg msg) {
        try {
            packBarcodeMsgMapper.updatePackBarcodeMsg(msg);
        }catch (Exception e){
            return R.error("修改失败");
        }
        return R.success("修改成功");
    }

    @Override
    public R<String> deletePackBarcodeMsg(int serialID) {
        try {
            packBarcodeMsgMapper.deletePackBarcodeMsg(serialID);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("删除失败");
        }
        return R.success("删除成功");
    }
}
