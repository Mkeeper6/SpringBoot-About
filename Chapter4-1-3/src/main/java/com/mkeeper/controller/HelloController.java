package com.mkeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/jstack")
    public void test(){
        while (true){

        }
    }

}
