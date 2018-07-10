package com.mkeeper.controller;

import com.mkeeper.common.R;
import com.mkeeper.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public R addUser(@Validated @RequestBody User user, BindingResult br) {

        if (br.hasErrors()) {
            return R.isFail().msg(br.getFieldError().getDefaultMessage());
        } else {

            return R.isOk().data(user);
        }
    }
}