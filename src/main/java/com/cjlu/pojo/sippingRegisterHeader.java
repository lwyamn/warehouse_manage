package com.cjlu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "发货登记单表头")
public class sippingRegisterHeader {
    @ApiModelProperty(value = "单据流水号",example = "53837")
    private Integer purchaseID;
    @ApiModelProperty(value = "登记单号",example = "DJ-2022-7-06139")
    private String registerID;
    @ApiModelProperty(value = "订单号",example = "DD-2022-7-03760")
    private String orderID;
    @ApiModelProperty(value = "交货日期",example = "2022-07-02")
    private Date deliveryDate;
    @ApiModelProperty(value = "客户名称",example = "杭州宏华数码科技股份有限公司")
    private String customerName;
    @ApiModelProperty(value = "托运地址",example = "浙江省绍兴市柯桥区安昌街道方党线盛陵村绍兴宇孵化器有限公司")
    private String consignAddress;
    @ApiModelProperty(value = "物流方式",example = "万家物流")
    private String transport;
    @ApiModelProperty(value = "联系人",example = "闫奇")
    private String contact;
    @ApiModelProperty(value = "联系方式",example = "null")
    private String contactWay;
}
