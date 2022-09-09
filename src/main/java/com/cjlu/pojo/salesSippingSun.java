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
@ApiModel(description = "销售发货单孙体")
public class salesSippingSun {
    @ApiModelProperty(value = "单据流水号",example = "54527")
    private Integer purchaseID;
    @ApiModelProperty(value = "单据表体号",example = "1")
    private Integer documentsTbodyID;
    @ApiModelProperty(value = "区位条码",example = "null")
    private String locationBarcode;
    @ApiModelProperty(value = "发货数量",example = "15")
    private BigDecimal sippingNumber;
    @ApiModelProperty(value = "区位库存",example = "15")
    private BigDecimal locationStock;
}
