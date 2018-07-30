package com.mkeeper;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

//@SpringBootApplication
public class Chapter511Main {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Chapter511Main.class, args);
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "a-b*c";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }
}
