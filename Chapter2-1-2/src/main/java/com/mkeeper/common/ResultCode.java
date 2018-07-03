package com.mkeeper.common;

/**
 *    通用前端状态返回码和信息
 *
 * @author liulei2
 * @create 2018/6/8 17:44
 */
public enum ResultCode {

    SUCCESS("执行成功", 0),
    FAIL("执行失败", 1),
    /*PARAM_INVALID("参数不合法", 2),
    ERROR("系统错误", 3),
    UNKNOWN("未知结果", 4),
    OTHERS("其他", 5),
    LOGIN_ERROR("登陆异常", 6),
    NO_PMS_ERROR("没有权限", 7)*/;//7 统一通知前端重定向

    private String msg;
    private int code;

    ResultCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int error) {
        this.code = code;
    }

    public static ResultCode geResultCodeEnumByCode(int code){
        for(ResultCode resultCode : ResultCode.values()){
            if(code == resultCode.getCode()){
                return resultCode;
            }
        }
        return null;
    }
}
