package com.cjlu.mapper;

import com.cjlu.pojo.finalProductStockInHeader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface finalProductStockInHeaderMapper {
    //插入入库内容
    int addProductToHeader(Map<String, Object> product);
    //取生产入库单最大单据流水号
    int getMaxPurchaseID();
    //查看入库登记单
    List<Map<String,Object>> queryStockInPaging(Map<String,Object> page);
    //删除入库登记单头
    int deleteStockInHeader(int purchaseID);
    //查询该表头有多少表体
    int queryDocumentsTbody(int purchaseID);
    //修改入库登记单表头
    int updateStockInHeader(finalProductStockInHeader productStockInHeader);
    //手动插入入库内容表头
    int addProductToHeaderJOG(finalProductStockInHeader productStockInHeader);
}
