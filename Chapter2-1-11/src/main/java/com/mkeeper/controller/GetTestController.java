package com.mkeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@RestController
public class GetTestController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/baidu/{key}")
    public String get1(@PathVariable String key) throws UnsupportedEncodingException {
        String encodeKey = URLEncoder.encode(key, "UTF-8");
        String url = "http://www.baidu.com/s?bdorz_come=1&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=" + encodeKey;
        return restTemplate.getForObject(url, String.class);
    }

}
