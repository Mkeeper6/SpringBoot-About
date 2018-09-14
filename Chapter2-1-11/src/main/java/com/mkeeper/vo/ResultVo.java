package com.mkeeper.vo;

public class ResultVo {
    private Integer code;
    private String data;

    public boolean success(){
        return 0 == code;
    }

    public String getData(){
        return data;
    }

}
