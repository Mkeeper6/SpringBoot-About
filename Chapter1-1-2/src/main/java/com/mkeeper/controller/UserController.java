package com.mkeeper.controller;

import com.mkeeper.config.UserProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserProperties userProperties;

    @GetMapping("/user")
    public String user() {
        log.info("info:");

        return userProperties.toString();
    }
}
