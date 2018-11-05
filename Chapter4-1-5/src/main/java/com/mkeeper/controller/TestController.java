package com.mkeeper.controller;

import com.mkeeper.entity.Stock;
import com.mkeeper.mapper.one.OneStockMapper;
import com.mkeeper.mapper.two.TwoStockMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private OneStockMapper oneStockMapper;
    @Resource
    private TwoStockMapper twoStockMapper;


    @GetMapping("/find")
    public Map<String,Object> index(){
        Map<String,Object> result = new HashMap<>();
        Stock entity = oneStockMapper.selectByPrimaryKey(1);
        Stock twoEntity = twoStockMapper.selectByPrimaryKey(2);

        result.put("entity",entity);
        result.put("twoEntity",twoEntity);

        return result;
    }
}
