package com.mkeeper.controller;

import com.alibaba.fastjson.JSON;
import com.mkeeper.common.R;
import com.mkeeper.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @PostMapping("/user")
    public R addUser(@RequestBody User user){
        log.info("user: {}", JSON.toJSONString(user));

        R r = R.isOk().data(user);

        log.info("result: {}", JSON.toJSONString(user));
        return r;
    }

}
