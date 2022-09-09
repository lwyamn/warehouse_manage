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
@ApiModel(description = "包装条码信息")
public class packBarcodeMsg {
    @ApiModelProperty(value = "单据流水号",example = "41192")
    private Integer purchaseID;
    @ApiModelProperty(value = "流水号",example = "241029")
    private Integer serialID;
    @ApiModelProperty(value = "生产批次号",example = "MS2022061317")
    private String lot;
    @ApiModelProperty(value = "包装规格",example = "5KG/方瓶/白色/EPSU143")
    private String packGL;
    @ApiModelProperty(value = "产品编号",example = "SUA001055BK")
    private String productID;
    @ApiModelProperty(value = "产品名称",example = "EPSON热升华墨水黑色（高端）")
    private String productName;
    @ApiModelProperty(value = "入库数量",example = "0")
    private BigDecimal stockInNumber;
}
