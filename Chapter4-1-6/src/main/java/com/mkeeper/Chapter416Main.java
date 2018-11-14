package com.mkeeper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.mkeeper.mapper")
@SpringBootApplication
public class Chapter416Main {
    public static void main(String[] args) {
        SpringApplication.run(Chapter416Main.class);
    }
}
