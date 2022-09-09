package com.cjlu.mapper;

import com.cjlu.pojo.packBarcodeMsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface packBarcodeMsgMapper {
    //流水号获取任务单
    packBarcodeMsg  getTaskList(int serialID);
    //获取条码信息并分页
    List<packBarcodeMsg> queryMsgPaging(Map<String,Object> page);
    //添加条码信息
    int addPackBarcodeMsg(packBarcodeMsg msg);
    //更新条码信息
    int updatePackBarcodeMsg(packBarcodeMsg msg);
    //删除条码信息
    int deletePackBarcodeMsg(int serialID);
}
