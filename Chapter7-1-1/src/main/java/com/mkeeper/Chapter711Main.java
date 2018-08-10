package com.mkeeper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Chapter711Main {

    public static void main(String[] args) {
        SpringApplication.run(Chapter711Main.class, args);
        /*SpringApplication app = new SpringApplication(Chapter711Main.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        log.info("Chapter7-1-1 is success!");*/
    }
}
