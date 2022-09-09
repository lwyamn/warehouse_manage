package com.cjlu.service;

import com.cjlu.pojo.productSpecGL;
import com.cjlu.util.R;

import java.util.List;
import java.util.Map;

public interface productSpecGLService {
    int addProductSpec(productSpecGL productSpec);
    Map<String,Integer> getFinalNumber(productSpecGL productSpec);
    int updateProductSpecFN(Map<String,Object> productSpec);
    List<productSpecGL> querySpecPaging(int currPage,int pageSize);
    R<String> updateProductSpec(productSpecGL productSpec);
    R<String> deleteProductSpec(int purchaseID);
    R<String> addProductSpecJOG(productSpecGL productSpec);
}
