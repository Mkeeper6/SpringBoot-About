package com.mkeeper;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DubboProviderMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderMain.class)
                .web(false)
                .run(args);
    }
}
