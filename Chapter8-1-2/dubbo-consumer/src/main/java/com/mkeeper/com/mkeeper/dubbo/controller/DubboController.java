package com.mkeeper.com.mkeeper.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mkeeper.dubbo.api.ComputeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @Reference(
            version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345"
    )
    private ComputeService computeService;

    @RequestMapping("/dubbo/add/{a}/{b}")
    public Integer sayHello(@PathVariable Integer a, @PathVariable Integer b) {
        return computeService.add(a, b);
    }
}
