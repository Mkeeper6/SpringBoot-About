package com.mkeeper.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mkeeper.dubbo.api.ComputeService;


@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultComputeService implements ComputeService {

    @Override
    public Integer add(int a, int b) {
        return a + b;
    }

}
