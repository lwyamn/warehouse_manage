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
@ApiModel(description = "墨水区位库存总账")
public class inkLocationStockGL {
    @ApiModelProperty(value = "单据流水号",example = "62351")
    private Integer purchaseID;
    @ApiModelProperty(value = "年",example = "2022")
    private Integer year;
    @ApiModelProperty(value = "月",example = "8")
    private Integer month;
    @ApiModelProperty(value = "产品编号",example = "DIB000960MG")
    private String productID;
    @ApiModelProperty(value = "产品名称",example = "京瓷高温分散墨水品红色(高端）")
    private String productName;
    @ApiModelProperty(value = "产品等级",example = "A级")
    private String productGrade;
    @ApiModelProperty(value = "区位条码",example = "YW001")
    private String locationBarcode;
    @ApiModelProperty(value = "批次号",example = "MS2022061384")
    private String batchNumber;
    @ApiModelProperty(value = "期初数量",example = "0")
    private BigDecimal startNumber;
    @ApiModelProperty(value = "入库数量",example = "10")
    private BigDecimal stockInNumber;
    @ApiModelProperty(value = "出库数量",example = "0")
    private BigDecimal stockOutNumber;
    @ApiModelProperty(value = "期末数量",example = "10")
    private BigDecimal finalNumber;

}
