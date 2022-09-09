package com.cjlu.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(description = "结果集")
public class R<T> {

    @ApiModelProperty(value = "结果代码",position = 0)
    private Integer code;

    @ApiModelProperty(value = "结果信息",position = 1)
    private String msg;

    @ApiModelProperty(value = "结果数据",position = 2)
    private T data;

    private Map map = new HashMap();
    public static <T> R<T> success(String msg) {
        R<T> r = new R<T>();
        r.msg = msg;
        r.code = 1;
        return r;
    }
    public static <T> R<T> success(String msg,Integer code) {
        R<T> r = new R<T>();
        r.code = code;
        r.msg = msg;
        return r;
    }
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}

