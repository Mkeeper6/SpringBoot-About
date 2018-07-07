package com.mkeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mkeeper on 2018/7/7.
 */
@RestController
public class UglyExceptionController {

    @GetMapping("/ugly")
    public Map<String, String> ugly(){
        Map<String, String> result = new HashMap<>();
        // TODO 直接捕获所有代码块，然后在 cache
        try {
            int i = 10 / 0;
            result.put("code", "200");
            result.put("data", "具体返回的结果集");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("message", "请求错误");
        }
        return result;
    }
}
