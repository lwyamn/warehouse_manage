package com.cjlu.service.impl;

import com.cjlu.mapper.inkLocationStockGLMapper;
import com.cjlu.pojo.inkLocationStockGL;
import com.cjlu.service.inkLocationStockGLService;
import com.cjlu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class inkLocationStockGLServiceImpl implements inkLocationStockGLService {
    @Autowired
    private inkLocationStockGLMapper inkLocationStockGLMapper;

    @Override
    public R<String> addAndUpdateInkLocationStock(inkLocationStockGL locationStock) {

        String batchNumber = locationStock.getBatchNumber();
        inkLocationStockGL inkLocationStock= inkLocationStockGLMapper.judgeInkLocationStock(batchNumber);
        if(inkLocationStock==null){
            try{
                inkLocationStockGLMapper.addInkLocationStock(locationStock);
            }catch (Exception e){
                return R.error("新建库存失败:"+e.getMessage());
            }
            return R.success("新建库存成功");
        }
        try{
            inkLocationStockGLMapper.updateInkLocationStock(locationStock);
        }catch (Exception e){
            return R.error("修改库存失败"+e.getMessage());
        }
        return R.success("修改库存成功");
    }

    @Override
    public Map<String, Integer> getFinalNumber(inkLocationStockGL locationStock) {
        return inkLocationStockGLMapper.getFinalNumber(locationStock);
    }

    @Override
    public int updateInkLocationStockS(Map<String,Object> locationStockMap){
        return inkLocationStockGLMapper.updateInkLocationStockS(locationStockMap);
    }

    @Override
    public List<inkLocationStockGL> queryGLPaging(int currPage,int pageSize){
        Map<String, Object> page = new HashMap();
        page.put("currIndex",(currPage-1)*pageSize);
        page.put("pageSize",pageSize);
        return inkLocationStockGLMapper.queryGLPaging(page);
    }

    @Override
    public R<String> deleteGL(int purchaseID) {
        try{
            inkLocationStockGLMapper.deleteGL(purchaseID);
        }catch (Exception e){
            return R.error("删除失败");
        }
        return R.success("删除成功");
    }

    @Override
    public R<String> updateGL(inkLocationStockGL locationStockGL) {
        try{
            inkLocationStockGLMapper.updateGL(locationStockGL);
        }catch (Exception e){
            return R.error("更新失败");
        }
        return R.success("更新成功");
    }

    @Override
    public R<String> addInkLocationStock(inkLocationStockGL locationStock) {
        try{
            inkLocationStockGLMapper.addInkLocationStock(locationStock);
        }catch (Exception e){
            return R.error("添加失败");
        }
        return R.success("添加成功");
    }


}
