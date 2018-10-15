package com.mkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter511Main {
    public static void main(String[] args){
        SpringApplication.run(Chapter511Main.class, args);

    }
}
