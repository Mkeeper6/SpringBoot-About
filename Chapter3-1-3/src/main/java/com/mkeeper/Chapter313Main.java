package com.mkeeper;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@DisallowConcurrentExecution
public class Chapter313Main {

    public static void main(String[] args) {
        SpringApplication.run(Chapter313Main.class, args);
    }
}
