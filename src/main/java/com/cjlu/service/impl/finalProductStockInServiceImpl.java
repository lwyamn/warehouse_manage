package com.cjlu.service.impl;

import com.alibaba.fastjson.JSON;
import com.cjlu.mapper.finalProductStockInHeaderMapper;
import com.cjlu.mapper.finalProductStockInSunMapper;
import com.cjlu.mapper.finalProductStockInTbodyMapper;
import com.cjlu.pojo.finalProductStockInHeader;
import com.cjlu.pojo.finalProductStockInSun;
import com.cjlu.pojo.finalProductStockInTbody;
import com.cjlu.service.finalProductStockInService;
import com.cjlu.util.R;
import com.cjlu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class finalProductStockInServiceImpl implements finalProductStockInService {

    @Autowired
    private finalProductStockInHeaderMapper finalProductStockInHeaderMapper;

    @Autowired
    private finalProductStockInTbodyMapper finalProductStockInTbodyMapper;

    @Autowired
    private finalProductStockInSunMapper finalProductStockInSunMapper;

    @Autowired
    private  RedisUtil redisUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> addProductToHeader(Map<String, Object> product) {
        int maxPurchaseID = finalProductStockInHeaderMapper.getMaxPurchaseID();
        String lot = (String) product.get("lot");
        if(lot==null){
            return R.error("出现错误没有传递批次号");
        }
        redisUtil.set("StockIn"+lot,maxPurchaseID,1);
        product.put("purchaseID",maxPurchaseID);
        try{
            finalProductStockInHeaderMapper.addProductToHeader(product);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error("出现错误"+e.getMessage());
        }
        return R.success("表头添加成功");
    }

    @Override
    public R<String> addProductToTbodyAndSun(Map<String, Object> product) {
        Object lot =  product.get("lot");
        if(lot==null){
            return R.error("出现错误没有传递批次号");
        }
        Integer maxPurchaseID = (Integer) redisUtil.get("StockIn"+lot);
        if(maxPurchaseID==null){
            return R.error("入库商品不是同批次，添加失败");
        }
        product.put("purchaseID",maxPurchaseID);
        try{
            finalProductStockInTbodyMapper.addProductToTbody(product);
            finalProductStockInSunMapper.addProductToSun(product);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error("出现错误"+e.getMessage());
        }
        return R.success("表孙表体添加成功");
    }

    @Override
    public R<String> endProductAdd(String lot) {
        redisUtil.del("StockIn"+lot);
        return R.success("清除成功");
    }

    @Override
    public List<Map<String, Object>> queryStockInPaging(int currPage,int pageSize) {
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return finalProductStockInHeaderMapper.queryStockInPaging(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> deleteStockIn(int purchaseID, int documentsTbodyID) {
        Map<String, Object> msg = new HashMap();
        msg.put("purchaseID",purchaseID);
        msg.put("documentsTbodyID",documentsTbodyID);
        try {
            finalProductStockInSunMapper.deleteStockInSun(msg);
            finalProductStockInTbodyMapper.deleteStockInTbody(msg);
            if (finalProductStockInHeaderMapper.queryDocumentsTbody(purchaseID)==0){
                finalProductStockInHeaderMapper.deleteStockInHeader(purchaseID);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return R.error("删除失败");
        }
        return R.success("删除成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> updateStockInAll(Map<String, Object> product) {
        finalProductStockInHeader productStockInHeader = JSON.parseObject(JSON.toJSONString(product),finalProductStockInHeader.class);
        finalProductStockInSun productStockInSun = JSON.parseObject(JSON.toJSONString(product),finalProductStockInSun.class);
        finalProductStockInTbody productStockInTbody = JSON.parseObject(JSON.toJSONString(product),finalProductStockInTbody.class);
        try {
            finalProductStockInSunMapper.updateStockInSun(productStockInSun);
            finalProductStockInTbodyMapper.updateStockInTbody(productStockInTbody);
            finalProductStockInHeaderMapper.updateStockInHeader(productStockInHeader);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return R.error("修改失败");
        }
        return R.error("修改成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> addProductToAllJOG(Map<String, Object> product) {
        finalProductStockInHeader productStockInHeader = JSON.parseObject(JSON.toJSONString(product),finalProductStockInHeader.class);
        finalProductStockInSun productStockInSun = JSON.parseObject(JSON.toJSONString(product),finalProductStockInSun.class);
        finalProductStockInTbody productStockInTbody = JSON.parseObject(JSON.toJSONString(product),finalProductStockInTbody.class);
        try {
            finalProductStockInSunMapper.addProductToSunJOG(productStockInSun);
            finalProductStockInTbodyMapper.addProductToTbodyJOG(productStockInTbody);
            finalProductStockInHeaderMapper.addProductToHeaderJOG(productStockInHeader);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return R.error("添加失败");
        }
        return R.error("添加成功");
    }
}
