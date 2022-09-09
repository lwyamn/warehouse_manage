package com.cjlu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "销售发货单表头")
public class salesSippingHeader {
    @ApiModelProperty(value = "单据流水号",example = "54527")
    private Integer purchaseID;
    @ApiModelProperty(value = "发货单号",example = "null")
    private String sippingID;
    @ApiModelProperty(value = "发货日期",example = "null")
    private Date sippingDate;
    @ApiModelProperty(value = "登记单号",example = "DJ-2022-7-06328")
    private String registerID;
    @ApiModelProperty(value = "发货地",example = "义乌")
    private String sippingAddress;
    @ApiModelProperty(value = "客户名称",example = "山东盈科杰数码科技有限公司")
    private String customName;
    @ApiModelProperty(value = "联系人",example = "王晓毅")
    private String contact;
    @ApiModelProperty(value = "电话",example = "null")
    private String phone;
    @ApiModelProperty(value = "托运地址",example = "河南省郑州市金水区经五路中原古玩城东厅宁昌印务")
    private String consignAddress;
    @ApiModelProperty(value = "制单人",example = "王文君")
    private String single;
    @ApiModelProperty(value = "制单时间",example = "null")
    private Date singleTime;
    @ApiModelProperty(value = "操作来源",example = "移动端")
    private String operateOrigin;
    @ApiModelProperty(value = "物流方式",example ="快递" )
    private String transport;
    @ApiModelProperty(value = "物流费用",example = "528.00")
    private BigDecimal Logistics;
    @ApiModelProperty(value = "订单类型",example = "成品")
    private String orderType;
}
