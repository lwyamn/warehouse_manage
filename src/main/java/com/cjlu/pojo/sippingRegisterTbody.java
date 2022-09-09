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
@ApiModel(description = "发货登记单表体")
public class sippingRegisterTbody {
    @ApiModelProperty(value = "单据流水号",example = "53838")
    private Integer purchaseID;
    @ApiModelProperty(value = "产品编号",example = "OTX000283XX")
    private String productID;
    @ApiModelProperty(value = "产品名称",example = "通用型清洗液A")
    private String productName;
    @ApiModelProperty(value = "产品小类",example = "无")
    private String productType;
    @ApiModelProperty(value = "标签内容",example = "Cleaning  Solution  清洗液CCS    CCS00000S")
    private String  labelContent;
    @ApiModelProperty(value = "规格",example = "5KG/方瓶/白色/CCS00000S")
    private String gl;
    @ApiModelProperty(value = "登记数量",example = "100")
    private BigDecimal registerNumber;
    @ApiModelProperty(value = "已发货数量",example = "0")
    private BigDecimal shippedNumber;
}
