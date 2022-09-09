package com.cjlu.mapper;


import com.cjlu.pojo.sippingRegisterTbody;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface sippingRegisterTbodyMapper {
    //获取需要发货的产品内容
    List<sippingRegisterTbody> getSippingRegisterTbody(int purchaseID);
    //修改配货单的已发数量
    int updateSippingRegisterTbodySN(Map<String,Object> sippingRegister);
    //删除配货单
    int deleteSippingRegisterTbody(int purchaseID);
    //修改配货单表体
    int updateSippingRegisterTbody(sippingRegisterTbody registerTbody);
}
