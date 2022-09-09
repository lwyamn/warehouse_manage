package com.cjlu.mapper;

import com.cjlu.pojo.finalProductStockInHeader;
import com.cjlu.pojo.finalProductStockInSun;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface finalProductStockInSunMapper {
    //入库单孙体插入入库产品数量和区位内容
    int addProductToSun(Map<String, Object> product);
    //删除入库单孙体
    int deleteStockInSun(Map<String, Object> msg);
    //修改入库登记单表孙
    int updateStockInSun(finalProductStockInSun productStockInSun);
    //手动插入入库内容
    int addProductToSunJOG(finalProductStockInSun productStockInSun);
}
