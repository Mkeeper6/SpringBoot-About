package com.mkeeper.controller;

import com.mkeeper.common.R;
import com.mkeeper.entity.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
public class UserController {

    @PostMapping("/user")
    public R addUser(@Validated @RequestBody User user, BindingResult br){

        if(br.hasErrors()){
            return R.isFail().msg(br.getFieldError().getDefaultMessage());
        } else {

            return R.isOk().data(user);
        }
    }


    @GetMapping("/user")
    public R test2(
            @NotBlank(message = "name 不能为空")
            @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间")
            String name ) {

        return R.isOk().data(name);
    }
}
