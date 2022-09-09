package com.cjlu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "产成品入库单表头")
public class finalProductStockInHeader {
    @ApiModelProperty(value = "单据流水号",example = "22565")
    private Integer purchaseID;
    @ApiModelProperty(value = "入库单号",example = "CR-2022-7-1659")
    private String stockInID;
    @ApiModelProperty(value = "生产批次号",example = "MS2022061311")
    private String lot;
    @ApiModelProperty(value = "入库人",example = "童翀晖")
    private String stockInPerson;
    @ApiModelProperty(value = "入库日期",example = "2022-07-02")
    private Date stockInDate;
}
