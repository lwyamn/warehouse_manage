package com.cjlu.mapper;

import com.cjlu.pojo.salesSippingHeader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface salesSippingHeaderMapper {
    //销售发货表头插入入库内容
    int addSalesSippingHeader(Map<String,Object> sippingTbody);
    //获取当前最大单据流水号
    int getMaxPurchaseID();
    //查找出库单并分页
    List<Map<String,Object>> querySalesSippingPaging(Map<String,Object> page);
    //删除表头
    int deleteSalesSippingHeader(int purchaseID);
    //查找该表头的表体数
    int queryDocumentsTbody(int purchaseID);
    //修改销售发货表头
    int updateSalesSippingHeader(salesSippingHeader sippingHeader);

}
