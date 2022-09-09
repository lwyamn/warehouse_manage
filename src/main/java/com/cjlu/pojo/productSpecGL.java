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
@ApiModel(description = "产品规格总账")
public class productSpecGL {
    @ApiModelProperty(value = "单据流水号",example = "3701")
    private Integer purchaseID;
    @ApiModelProperty(value = "产品编号",example = "DIB000374VI")
    private String productID;
    @ApiModelProperty(value = "产品等级",example = "A级")
    private String productGrade;
    @ApiModelProperty(value = "区位条码",example = "YW001")
    private String locationBarcode;
    @ApiModelProperty(value = "规格",example = "5KG/方瓶/白色/CDK00010V")
    private String gl;
    @ApiModelProperty(value = "批次号",example = "MS2018040334")
    private String batchNumber;
    @ApiModelProperty(value = "期末数量",example = "10")
    private BigDecimal finalNumber;

}
