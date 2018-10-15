package com.mkeeper.controller;

import com.mkeeper.service.DoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    private DoingService doingService;

    @GetMapping("/doing/{a}/{b}")
    public Integer doing(@PathVariable Integer a, @PathVariable Integer b){
        return doingService.add(a, b);
    }
}
