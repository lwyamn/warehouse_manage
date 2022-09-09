package com.cjlu.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "产成品入库单表体")
public class finalProductStockInTbody {
    @ApiModelProperty(value = "单据流水号",example = "22566")
    private Integer purchaseID;
    @ApiModelProperty(value = "单据表体号",example = "1")
    private Integer documentsTbodyID;
    @ApiModelProperty(value = "生产批次号",example ="MS2022061208")
    private String lot;
    @ApiModelProperty(value = "产品编号",example = "XXX101457YE")
    private String productID;
    @ApiModelProperty(value = "产品名称",example = "京瓷活性墨水黄色（高端")
    private String productName;
    @ApiModelProperty(value = "产品小类",example = "黄色")
    private String productType;
    @ApiModelProperty(value = "产品等级",example = "A级")
    private String productGrade;
    @ApiModelProperty(value = "规格",example = "5KG/方瓶/白色/KYRE206YE")
    private String gl;
}
