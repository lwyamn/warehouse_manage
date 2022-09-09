package com.cjlu.service;

import com.cjlu.pojo.inkLocationStockGL;
import com.cjlu.util.R;

import java.util.List;
import java.util.Map;

public interface inkLocationStockGLService {
    R<String> addAndUpdateInkLocationStock(inkLocationStockGL locationStock);
    Map<String,Integer> getFinalNumber(inkLocationStockGL locationStock);
    int updateInkLocationStockS(Map<String,Object> locationStockMap);
    List<inkLocationStockGL> queryGLPaging(int currPage,int pageSize);
    R<String> deleteGL(int purchaseID);
    R<String> updateGL(inkLocationStockGL locationStockGL);
    R<String> addInkLocationStock(inkLocationStockGL locationStock);
}
