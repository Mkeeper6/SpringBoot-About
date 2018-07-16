package com.mkeeper.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.TimeUnit;

@DisallowConcurrentExecution //禁止任务并行
@Slf4j
public class UploadTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext){
        try {
            log.info("任务开始");
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            log.info("任务异常");
        } finally {
            log.info("任务结束");
        }
    }
}
