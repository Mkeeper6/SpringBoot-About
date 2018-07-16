package com.mkeeper.quartz.config;

import com.mkeeper.quartz.UploadTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartzConfig {

    //指定了具体需要执行的类，只不过具体的方法就是我们需要实现的excuteInternal
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(UploadTask.class)
                .withIdentity("uploadTask").storeDurably()
                .build();
    }


    //uploadTaskTrigger指定了触发的规则
    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("uploadTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
