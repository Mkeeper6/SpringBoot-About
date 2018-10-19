package com.mkeeper.config;

import com.mkeeper.factory.ScheduleJobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class ScheduleConfig {
    @Autowired
    private ScheduleJobFactory scheduleJobFactory;

    @Bean
    @Qualifier("scheduleBean")
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 名称
        schedulerFactoryBean.setSchedulerName("TASK_EXECUTOR");
        // 延迟10秒启动Scheduler
        schedulerFactoryBean.setStartupDelay(10);
        // 通过applicationContextSchedulerContextKey属性配置spring上下文
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 设置是否任意一个已定义的Job会覆盖现有的Job。默认为false，即已定义的Job不会覆盖现有的Job。
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        // 自动开始
        schedulerFactoryBean.setAutoStartup(true);
        // 数据源
        schedulerFactoryBean.setDataSource(dataSource);
        // 将JobFactory改为自定义的，否则在 Job 中注入 Bean 会失败
        schedulerFactoryBean.setJobFactory(scheduleJobFactory);
        return schedulerFactoryBean;
    }
}
