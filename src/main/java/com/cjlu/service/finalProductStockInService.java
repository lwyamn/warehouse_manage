package com.cjlu.service;

import com.cjlu.util.R;

import java.util.List;
import java.util.Map;

public interface finalProductStockInService {
    R<String> addProductToHeader(Map<String,Object> product);
    R<String> addProductToTbodyAndSun(Map<String,Object> product);
    R<String> endProductAdd(String lot);
    List<Map<String,Object>> queryStockInPaging(int currPage,int pageSize);
    R<String> deleteStockIn(int purchaseID,int documentsTbodyID);
    R<String> updateStockInAll(Map<String,Object> product);
    R<String> addProductToAllJOG(Map<String,Object> product);

}
