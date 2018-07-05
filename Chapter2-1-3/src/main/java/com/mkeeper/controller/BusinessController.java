package com.mkeeper.controller;

import com.mkeeper.common.R;
import com.mkeeper.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @GetMapping("/business/{param}")
    public R business(@PathVariable String param){

        if("ok".equals(param)){
            return R.isOk();
        } else {
            throw new BusinessException("business exception: param = " + param);
        }

    }
}
