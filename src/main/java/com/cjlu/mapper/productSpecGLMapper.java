package com.cjlu.mapper;

import com.cjlu.pojo.productSpecGL;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface productSpecGLMapper {
    //产品规格总账中插入库数据
    int addProductSpec(productSpecGL productSpec);
    //获取批次规格库存数量
    Map<String,Integer> getFinalNumber(productSpecGL productSpec);
    //修改产品规格总账中数据期末数量
    int updateProductSpecFN(Map<String,Object> productSpec);
    //查询产品规格总账
    List<productSpecGL> querySpecPaging(Map<String,Object> page);
    //修改产品规格总账
    int updateProductSpec(productSpecGL productSpec);
    //删除产品规格总账
    int deleteProductSpec(int purchaseID);
    //添加产品规格总账手动
    int addProductSpecJOG(productSpecGL productSpecGL);
}
