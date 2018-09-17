package com.mkeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.net.URLEncoder;
import java.util.Collections;


@Slf4j
@RestController
public class FileTestController {
    @Resource
    private RestTemplate restTemplate;

    // post文件上传
    // 场景说明：只适合小文件（20MB以内）上传
    @RequestMapping("/postFile")
    public String testPostFileBody() {
        String filePath = "D:/config.png";

        //通过磁盘文件上传，如果产生了临时文件，一定要记得删除，否则，临时文件越积越多，磁盘会爆
        FileSystemResource resource = new FileSystemResource(new File(filePath));

        String url = "***";//测试的时候换成自己的配置
        String appId = "***";//测试的时候换成自己的配置
        String secureKey = "***";//测试的时候换成自己的配置
        String time = String.valueOf(System.currentTimeMillis());
        String pubStr = "1";
        String tempStr = String.format("app_id=%s&is_public=%s&time=%s&vframe=0%s", appId, pubStr, time, secureKey);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("is_public", pubStr);
        form.add("vframe", "0");
        form.add("file", resource);
        form.add("app_id", appId);
        form.add("time", time);
        form.add("sign", DigestUtils.md5(tempStr));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //headers.add("xx", "yy");//可以加入自定义的header头
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<>(form, headers);
        String json = restTemplate.postForObject(url, formEntity, String.class);
        return json;
    }

    //文件下载
    //场景说明：只适合小文件（10MB以内）下载
    @RequestMapping("/downloadFile")
    public ResponseEntity testDownloadFile() throws Exception {
        String url = "http://editor.baidu.com/editor/download/BaiduEditor(Online)_5-9-16.exe";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        byte[] bytes = response.getBody();
        long contentLength = bytes != null ? bytes.length : 0;
        headers.setContentLength((int) contentLength);
        headers.setContentDispositionFormData("baidu.exe", URLEncoder.encode("百度安装包.exe", "UTF-8"));
        return new ResponseEntity<>(response.getBody(), headers, HttpStatus.OK);
    }
}
