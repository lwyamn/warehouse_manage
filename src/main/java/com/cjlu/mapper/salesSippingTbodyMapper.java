package com.cjlu.mapper;

import com.cjlu.pojo.salesSippingHeader;
import com.cjlu.pojo.salesSippingTbody;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface salesSippingTbodyMapper {
    //销售发货单表体插入出库产品内容
    int addSalesSippingTbody(Map<String,Object> sippingTbody);
    //删除表体
    int deleteSalesSippingTbody(Map<String,Object> msg);
    //修改销售发货表体
    int updateSalesSippingHeader(salesSippingTbody sippingTbody);
}
