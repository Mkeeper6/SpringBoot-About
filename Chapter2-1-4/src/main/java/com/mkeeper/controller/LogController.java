package com.mkeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//如果不想每次都写private final Logger logger = LoggerFactory.getLogger(XXX.class); 可以用注解@Slf4j
@Slf4j
@RestController
public class LogController {

    @GetMapping("/log")
    public void log(){
        log.debug(this.getClass().getSimpleName() + ": debug");
        log.info(this.getClass().getSimpleName() + ": info");
        log.warn(this.getClass().getSimpleName() + ": warn");
        log.error(this.getClass().getSimpleName() + ": error");
    }
}
