package com.mkeeper.spring_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 基于 Spring 自带的
 */
@Component
@Slf4j
public class SpringTaskDemo {

    /**
     * cron： cron表达式，根据表达式循环执行，与fixedRate属性不同的是它是将时间进行了切割。
     * （@Scheduled(cron = "0/5 * * * * *")任务将在5、10、15、20...这种情况下进行工作）
     * fixedRate： 每隔多久执行一次，无视工作时间（@Scheduled(fixedRate = 1000) 假设第一次工作时间为2018-05-29 16:58:28，工作时长为3秒，那么下次任务的时候就是2018-05-29 16:58:31）
     * fixedDelay： 当前任务执行完毕后等待多久继续下次任务（@Scheduled(fixedDelay = 3000) 假设第一次任务工作时间为2018-05-29 16:54:33，工作时长为5秒，那么下次任务的时间就是2018-05-29 16:54:41）
     * initialDelay： 第一次执行延迟时间，只是做延迟的设定，与fixedDelay关系密切，配合使用，相辅相成。
     *
     */

    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        log.info("schedule1 每1m秒执行一次: {}", LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        log.info("schedule2 每1m秒执行一次: {}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }

}
