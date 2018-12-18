package com.mkeeper;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.mkeeper.mapper")
public class Chapter412Main {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Chapter412Main.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        log.info("Chapter4-1-2 is success!");
    }
}
