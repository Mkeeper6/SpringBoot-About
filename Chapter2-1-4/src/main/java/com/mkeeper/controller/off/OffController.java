package com.mkeeper.controller.off;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OffController {

    @GetMapping("/log/off")
    public void log(){
        log.debug(this.getClass().getSimpleName() + ": debug");
        log.info(this.getClass().getSimpleName() + ": info");
        log.warn(this.getClass().getSimpleName() + ": warn");
        log.error(this.getClass().getSimpleName() + ": error");
    }
}
