package com.cjlu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "销售发货单表体")
public class salesSippingTbody {
    @ApiModelProperty(value = "单据流水号",example = "54527")
    private Integer purchaseID;
    @ApiModelProperty(value = "单据表体号",example = "1")
    private Integer documentsTbodyID;
    @ApiModelProperty(value = "行号",example = "1")
    private Integer autoID;
    @ApiModelProperty(value = "产品小类",example = "白色")
    private String productType;
    @ApiModelProperty(value = "产品编号",example = "PTB000894BK")
    private String productID;
    @ApiModelProperty(value = "产品名称",example ="京瓷印刷颜料墨水白色")
    private String productName;
    @ApiModelProperty(value = "规格",example = "10KG/方瓶/白色/KYPI220BK-3540")
    private String gl;
    @ApiModelProperty(value = "容量",example = "1")
    private Integer volume;
    @ApiModelProperty(value = "产品等级",example = "null")
    private String productGrade;
    @ApiModelProperty(value = "批次号",example = "MS2022061399")
    private String batchNumber;
    @ApiModelProperty(value = "登记数量",example = "400")
    private BigDecimal registerNumber;
    @ApiModelProperty(value = "未发货数量",example = "null")
    private BigDecimal noShippedNumber;
    @ApiModelProperty(value = "批次库存",example = "15")
    private BigDecimal batchStock;
    @ApiModelProperty(value = "当前库存",example = "15")
    private BigDecimal nowStock;
}
