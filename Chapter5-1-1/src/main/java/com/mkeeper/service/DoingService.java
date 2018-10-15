package com.mkeeper.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@CacheConfig(cacheNames = "myCache")
@Service
@Slf4j
public class DoingService {

    @Cacheable(key = "targetClass + methodName + #a + #b")
    public Integer add(Integer a , Integer b){
        log.info("开始计算");
        return a + b;
    }
}
