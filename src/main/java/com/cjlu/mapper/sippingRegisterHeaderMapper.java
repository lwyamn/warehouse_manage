package com.cjlu.mapper;

import com.cjlu.pojo.sippingRegisterHeader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface sippingRegisterHeaderMapper {
    //获取配货单条码内容
    sippingRegisterHeader getSippingRegisterHeader(String registerID);
    //获取配货单并分页
    List<Map<String,Object>> querySippingRegisterPaging(Map<String,Object> page);
    //删除配货单
    int deleteSippingRegisterHeader(int purchaseID);
    //修改配货单表头
    int updateSippingRegisterHeader(sippingRegisterHeader registerHeader);
}
