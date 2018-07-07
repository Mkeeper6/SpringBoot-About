package com.mkeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mkeeper on 2018/7/7.
 */
@RestController
public class BadExceptionController {

    @GetMapping("/bad")
    public String bad(){
        // todo 业务逻辑

        Object object = null;
        // 模拟空指针异常
        object.toString();

        return "success";
    }

}
