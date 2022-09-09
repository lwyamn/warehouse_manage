package com.cjlu.service;

import com.cjlu.util.R;

import java.util.List;
import java.util.Map;

public interface salesSippingService {
    String addProductToHeader(Map<String,Object> sippingHeader);
    String addProductToTbodyAndSun(Map<String,Object> sippingTbody);
    String endProductAdd(String registerID);
    List<Map<String,Object>> querySalesSippingPaging(int currPage,int pageSize);
    R<String> deleteSalesSipping(int purchaseID,int documentsTbodyID);
    R<String> updateSalesSipping(Map<String,Object> salesSipping);
}
