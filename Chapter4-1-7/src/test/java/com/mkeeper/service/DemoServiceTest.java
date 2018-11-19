package com.mkeeper.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoServiceTest {

    @Resource
    private DemoService demoService;

    @Test
    public void demo() {
        demoService.demo();
    }
}