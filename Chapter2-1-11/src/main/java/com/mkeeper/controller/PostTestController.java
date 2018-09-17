package com.mkeeper.controller;

import com.mkeeper.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PostTestController {

    @Resource
    private RestTemplate restTemplate;

    //post表单演示
    @GetMapping("/postForm")
    public String testPostForm() {
        // 填写url
        String url = "";
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();

        // 填写表单
        form.add("name", "**");
        form.add("age", "**");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //headers.add("xx", "yy");//可以加入自定义的header头
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(form, headers);
        String json = restTemplate.postForObject(url, formEntity, String.class);
        return json;
    }

    @RequestMapping("/postBody")
    public String testPostBody() {
        // 填写url
        String url = "";

        // 填写json串
        String jsonBody = "{\n"
                + "    \"name\": \"XX\",\n"
                + "    \"age\": \"12\",\n"
                + "    \"sex\": \"man\"\n"
                + "}\n";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("xx", "yy");//可以加入自定义的header头
        HttpEntity<String> bodyEntity = new HttpEntity<>(jsonBody, headers);

        //1.直接拿原始json串
        String json = restTemplate.postForObject(url, bodyEntity, String.class);

        //2.将原始的json传转成java对象，rest template可以自动完成
        ResultVo resultVo = restTemplate.postForObject(url, bodyEntity, ResultVo.class);
        if (resultVo != null && resultVo.success()) {
            Object res = resultVo.getData();
            log.info("处理成功，返回数据: {}", resultVo.getData());
        } else {
            log.info("处理失败，响应结果: {}", resultVo);
        }

        return json;//返回的是分包api的json
    }

}