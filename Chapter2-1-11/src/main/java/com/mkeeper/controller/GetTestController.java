package com.mkeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    //最简单的get操作
    @GetMapping("/baidu1/{key}")
    public String get1(@PathVariable String key) throws UnsupportedEncodingException {
        String encodeKey = URLEncoder.encode(key, "UTF-8");

        String url = "http://www.baidu.com/s?bdorz_come=1&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=" + encodeKey;

        return restTemplate.getForObject(url, String.class); //返回百度主站html
    }

    //需要自定义header头的get操作
    @GetMapping("/baidu2/{key}")
    public String get2(@PathVariable String key) throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();

        headers.set("MyHeaderKey", "MyHeaderValue");

        HttpEntity entity = new HttpEntity(headers);

        String encodeKey =URLEncoder.encode(key, "UTF-8");

        String url = "http://www.baidu.com/s?bdorz_come=1&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=" + encodeKey;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return  response.getBody(); //返回百度主站html
    }

}
