package com.cjlu.mapper;

import com.cjlu.pojo.salesSippingHeader;
import com.cjlu.pojo.salesSippingSun;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface salesSippingSunMapper {
    //销售发货单孙体插入发货产品数量和区位内容
    int addSalesSippingSun(Map<String,Object> sippingTbody);
    //删除表孙
    int deleteSalesSippingSun(Map<String,Object> msg);
    //修改销售发货表孙
    int updateSalesSippingHeader(salesSippingSun sippingSun);
}
