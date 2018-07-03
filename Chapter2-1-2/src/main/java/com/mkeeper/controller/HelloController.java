package com.mkeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 等同于 （@Controller 与 @ResponseBody）
@RestController
public class HelloController {

    // @GetMapping 等同于 （@RequestMapping(method = RequestMethod.GET)）
    @GetMapping("/hello")
    public String hello(){
        return "Hello SpringBoot";


    }
}
