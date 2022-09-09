package com.cjlu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class log {


    private String id;//id


    private String operationUser;//操作人


    private String requestPath;//请求路径


    private String executionTime;//方法执行时间


    private String parameter;//方法入参


    private String action;//操作方法


    private String methodDesc;//方法描述


    private String systemType;//系统类型


    private String actionType;//操作类型

    private String ip;//ip地址

    public log(String operationUser, String requestPath, String executionTime,
                  String parameter, String action, String methodDesc, String systemType, String actionType,String ip) {
        super();
        this.operationUser = operationUser;
        this.requestPath = requestPath;
        this.executionTime = executionTime;
        this.parameter = parameter;
        this.action = action;
        this.methodDesc = methodDesc;
        this.systemType = systemType;
        this.actionType = actionType;
        this.ip = ip;
    }

}
