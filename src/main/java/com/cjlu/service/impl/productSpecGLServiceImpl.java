package com.cjlu.service.impl;

import com.cjlu.mapper.productSpecGLMapper;
import com.cjlu.pojo.productSpecGL;
import com.cjlu.service.productSpecGLService;
import com.cjlu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class productSpecGLServiceImpl implements productSpecGLService {

    @Autowired
    private productSpecGLMapper productSpecGLMapper;


    @Override
    public int addProductSpec(productSpecGL productSpec) {

        return productSpecGLMapper.addProductSpec(productSpec);
    }

    @Override
    public Map<String, Integer> getFinalNumber(productSpecGL productSpec) {
        return productSpecGLMapper.getFinalNumber(productSpec);
    }

    @Override
    public  int updateProductSpecFN(Map<String,Object> productSpec){
        return productSpecGLMapper.updateProductSpecFN(productSpec);
    }

    @Override
    public List<productSpecGL> querySpecPaging(int currPage, int pageSize) {
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return productSpecGLMapper.querySpecPaging(page);
    }

    @Override
    public R<String> updateProductSpec(productSpecGL productSpec) {
        try {
            productSpecGLMapper.updateProductSpec(productSpec);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("修改失败");
        }
        return R.success("修改成功");
    }

    @Override
    public R<String> deleteProductSpec(int purchaseID) {
        try {
            productSpecGLMapper.deleteProductSpec(purchaseID);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("删除失败");
        }
        return R.success("删除成功");
    }

    @Override
    public R<String> addProductSpecJOG(productSpecGL productSpec) {
        try {
            productSpecGLMapper.addProductSpecJOG(productSpec);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("添加失败");
        }
        return R.success("添加成功");
    }
}
