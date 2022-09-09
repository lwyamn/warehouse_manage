package com.cjlu.service.impl;


import com.alibaba.fastjson.JSON;
import com.cjlu.mapper.sippingRegisterHeaderMapper;
import com.cjlu.mapper.sippingRegisterTbodyMapper;
import com.cjlu.pojo.*;
import com.cjlu.service.sippingRegisterService;
import com.cjlu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class sippingRegisterServiceImpl implements sippingRegisterService {

    @Autowired
    private sippingRegisterHeaderMapper sippingRegisterHeaderMapper;

    @Autowired
    private sippingRegisterTbodyMapper sippingRegisterTbodyMapper;

    @Override
    public sippingRegisterHeader getSippingRegisterHeader(String registerID) {
        return sippingRegisterHeaderMapper.getSippingRegisterHeader(registerID);
    }

    @Override
    public List<sippingRegisterTbody> getSippingRegisterTbody(int purchaseID) {
        return sippingRegisterTbodyMapper.getSippingRegisterTbody(purchaseID);
    }

    @Override
    public int updateSippingRegisterTbodySN(Map<String, Object> sippingRegister) {
        return sippingRegisterTbodyMapper.updateSippingRegisterTbodySN(sippingRegister);
    }

    @Override
    public List<Map<String, Object>> querySippingRegisterPaging(int currPage, int pageSize) {
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return sippingRegisterHeaderMapper.querySippingRegisterPaging(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> deleteSippingRegister(int purchaseID) {

        try {
            sippingRegisterHeaderMapper.deleteSippingRegisterHeader(purchaseID);
            sippingRegisterTbodyMapper.deleteSippingRegisterTbody(purchaseID);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error("删除失败");
        }
        return R.success("删除成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> updateSippingRegisterAll(Map<String, Object> sippingRegister) {
        sippingRegisterHeader registerHeader = JSON.parseObject(JSON.toJSONString(sippingRegister),sippingRegisterHeader.class);
        sippingRegisterTbody registerTbody = JSON.parseObject(JSON.toJSONString(sippingRegister),sippingRegisterTbody.class);
        try {
            sippingRegisterHeaderMapper.updateSippingRegisterHeader(registerHeader);
            sippingRegisterTbodyMapper.updateSippingRegisterTbody(registerTbody);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return R.error("修改失败");
        }
        return R.error("修改成功");
    }

}
