package com.mkeeper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.mkeeper.mapper")
@SpringBootApplication
public class Chapter417Main {
    public static void main(String[] args) {
        SpringApplication.run(Chapter417Main.class,args);
    }
}
