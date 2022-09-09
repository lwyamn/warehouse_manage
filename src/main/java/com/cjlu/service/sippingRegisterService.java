package com.cjlu.service;

import com.cjlu.pojo.sippingRegisterHeader;
import com.cjlu.pojo.sippingRegisterTbody;
import com.cjlu.util.R;

import java.util.List;
import java.util.Map;

public interface sippingRegisterService {
    sippingRegisterHeader getSippingRegisterHeader(String registerID);
    List<sippingRegisterTbody> getSippingRegisterTbody(int purchaseID);
    int updateSippingRegisterTbodySN(Map<String,Object> sippingRegister);
    List<Map<String,Object>> querySippingRegisterPaging(int currPage,int pageSize);
    R<String> deleteSippingRegister(int purchaseID);
    R<String> updateSippingRegisterAll(Map<String,Object> sippingRegister);
}
