package com.mkeeper.common;

import lombok.Data;

import java.io.Serializable;

/**
 *    通用响应体
 */
@Data
public class R<T> implements Serializable {

    private T data; //服务端数据
    private int status = 0; //状态码，0：成功，1：失败
    private String msg = ""; //描述信息

    public static R isOk() {
        return new R().msg("成功");
    }

    public static R isFail() {
        return new R().status(1).msg("失败");
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
