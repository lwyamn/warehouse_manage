package com.cjlu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "账号")
public class user{

    @ApiModelProperty(value = "OID",example = "620")
    private Integer OID;
    @ApiModelProperty(value = "用户ID",example = "tch")
    private String userID;
    @ApiModelProperty(value = "用户名",example = "童翀晖")
    private String userName;
    @ApiModelProperty(value = "UserDesc",example = "null")
    private String userDesc;
    @ApiModelProperty(value = "Password",example = "tch")
    private String password;
    @ApiModelProperty(value = "uGroup",example = "0")
    private Integer uGroup;
    @ApiModelProperty(value = "是否停止使用",example = "0")
    private Integer unUsed;
    @ApiModelProperty(value = "是否是管理员",example = "1")
    private Integer isAdministrator;
    @ApiModelProperty(value = "电话号码",example = "null")
    private String phoneNo;
    @ApiModelProperty(value = "邮箱",example = "null")
    private String email;
}
