package com.cjlu.mapper;

import com.cjlu.pojo.finalProductStockInSun;
import com.cjlu.pojo.finalProductStockInTbody;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface finalProductStockInTbodyMapper {
    //入库单表体插入入库产品内容
    int addProductToTbody(Map<String, Object> product);
    //删除入库单表体
    int deleteStockInTbody(Map<String, Object> msg);
    //修改入库登记单表体
    int updateStockInTbody(finalProductStockInTbody productStockInTbody);
    //手动插入入库内容
    int addProductToTbodyJOG(finalProductStockInTbody productStockInTbody);
}
