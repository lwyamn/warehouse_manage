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
@ApiModel(description = "产成品入库单孙体")
public class finalProductStockInSun {
    @ApiModelProperty(value = "单据流水号",example = "22565")
    private Integer purchaseID;
    @ApiModelProperty(value = "单据表体号",example = "1")
    private Integer documentsTbodyID;
    @ApiModelProperty(value = "区位条码",example = "YW001")
    private String locationBarcode;
    @ApiModelProperty(value = "入库数量",example = "0")
    private String stockInNumber;
}
