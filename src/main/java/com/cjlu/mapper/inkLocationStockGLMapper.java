package com.cjlu.mapper;

import com.cjlu.pojo.inkLocationStockGL;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface inkLocationStockGLMapper {
    //插入入库墨水区位库存
    int addInkLocationStock(inkLocationStockGL locationStock);
    //更新入库墨水区位库存
    int updateInkLocationStock(inkLocationStockGL locationStock);
    //通过流水号查询墨水区位库存
    inkLocationStockGL judgeInkLocationStock(String batchNumber);
    //获取墨水区位库存总账期末数量
    Map<String,Integer> getFinalNumber(inkLocationStockGL locationStock);
    //修改发货墨水区位库存总账中数据
    int updateInkLocationStockS(Map<String,Object> locationStockMap);
    //查看墨水区位库存分页
    List<inkLocationStockGL> queryGLPaging(Map<String,Object> page);
    //删除记录
    int deleteGL(int purchaseID);
    //修改记录
    int updateGL(inkLocationStockGL locationStockGL);
}
