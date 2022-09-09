package com.cjlu.service.impl;

import com.alibaba.fastjson.JSON;
import com.cjlu.mapper.*;
import com.cjlu.pojo.*;
import com.cjlu.service.salesSippingService;
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
public class salesSippingServiceImpl implements salesSippingService {

    @Autowired
    private salesSippingHeaderMapper salesSippingHeaderMapper;

    @Autowired
    private salesSippingTbodyMapper salesSippingTbodyMapper;

    @Autowired
    private salesSippingSunMapper salesSippingSunMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addProductToHeader(Map<String, Object> sippingHeader) {
        int maxPurchaseID = salesSippingHeaderMapper.getMaxPurchaseID();
        String registerID = (String) sippingHeader.get("registerID");
        if (registerID==null){
            return "没有传递订单号参数";
        }
        redisUtil.set("StockIn"+registerID,maxPurchaseID,1);
        sippingHeader.put("purchaseID",maxPurchaseID);
        try{
            salesSippingHeaderMapper.addSalesSippingHeader(sippingHeader);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "出现错误"+e.getMessage();
        }
        return "添加成功";
    }

    @Override
    public String addProductToTbodyAndSun(Map<String, Object> sippingTbody) {
        String registerID = (String) sippingTbody.get("registerID");
        if (registerID==null){
            return "没有传递订单号参数";
        }
        Integer purchaseID = (Integer) redisUtil.get("StockIn"+registerID);
        sippingTbody.put("purchaseID",purchaseID);
        try{
            salesSippingSunMapper.addSalesSippingSun(sippingTbody);
            salesSippingTbodyMapper.addSalesSippingTbody(sippingTbody);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "出现错误"+e.getMessage();
        }
        return "添加成功";
    }

    @Override
    public String endProductAdd(String registerID) {
        redisUtil.del("StockOut"+registerID);
        return "清除成功";
    }

    @Override
    public List<Map<String, Object>> querySalesSippingPaging(int currPage, int pageSize) {
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return salesSippingHeaderMapper.querySalesSippingPaging(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> deleteSalesSipping(int purchaseID,int documentsTbodyID) {
        Map<String, Object> msg = new HashMap();
        msg.put("purchaseID",purchaseID);
        msg.put("documentsTbodyID",documentsTbodyID);
        try {
            salesSippingTbodyMapper.deleteSalesSippingTbody(msg);
            salesSippingSunMapper.deleteSalesSippingSun(msg);
            if (salesSippingHeaderMapper.queryDocumentsTbody(purchaseID)==0){
                salesSippingHeaderMapper.deleteSalesSippingHeader(purchaseID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("删除失败");
        }
        return R.success("删除成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> updateSalesSipping(Map<String, Object> salesSipping) {
        salesSippingHeader sippingHeader = JSON.parseObject(JSON.toJSONString(salesSipping),salesSippingHeader.class);
        salesSippingTbody sippingTbody = JSON.parseObject(JSON.toJSONString(salesSipping),salesSippingTbody.class);
        salesSippingSun sippingSun = JSON.parseObject(JSON.toJSONString(salesSipping),salesSippingSun.class);
        try {
            salesSippingHeaderMapper.updateSalesSippingHeader(sippingHeader);
            salesSippingSunMapper.updateSalesSippingHeader(sippingSun);
            salesSippingTbodyMapper.updateSalesSippingHeader(sippingTbody);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return R.error("修改失败");
        }
        return R.error("修改成功");
    }
}
