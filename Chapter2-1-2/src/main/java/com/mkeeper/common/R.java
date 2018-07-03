package com.mkeeper.common;

import lombok.Data;

import java.io.Serializable;

/**
 *    通用响应体
 */
@Data
public class R<T> implements Serializable {

    private T data; //服务端数据
    private int status = ResultCode.SUCCESS.getCode(); //状态码
    private String msg = ""; //描述信息

    public static R isOk() {
        return new R().msg(ResultCode.SUCCESS.getMsg());
    }

    public static R isFail() {
        return new R().status(ResultCode.FAIL.getCode()).msg(ResultCode.FAIL.getMsg());
    }

    public static R isFail(Throwable e) {
        return isFail().msg(e);
    }

    public R msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public R data(T data) {
        this.setData(data);
        return this;
    }

    public R msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public R status(int status) {
        this.setStatus(status);
        return this;
    }

}
