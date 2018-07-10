package com.mkeeper.entity;

import com.mkeeper.annotation.DateTime;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull(message = "名字不能为空")
    @Length(min = 4, max = 10, message = "name 长度必须在 {min} - {max} 之间")
    private String name;


    @NotNull(message = "生日不能为空")
    @DateTime(format = "yyyyMMdd", message = "格式错误，正确格式为：yyyyMMdd")
    private String birthday;


}
