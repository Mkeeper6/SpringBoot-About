package com.mkeeper.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
@Slf4j
public class StaticJob {
    private final static long SECOND = 1000;


    /**
     * fixedDelay: Fixed wait time
     * This is fixed delay, will execute per 10 seconds
     */
    @Scheduled(fixedDelay = 10 * SECOND)
    public void fixedDelayJob() {
        log.info("{}\tfixedDelay", System.currentTimeMillis()/1000);
    }

    /**
     * fixedRate: Fixed interval time, will execute per 10 seconds
     */
    @Scheduled(fixedRate = 10 * SECOND)
    public void fixedRate() {
        log.info("{}\tfixedRate", System.currentTimeMillis()/100);
    }

    /**
     * cron: execute by cron expression
     */
    @Scheduled(cron = "*/10 * * * * *")
    public void cron() {
        log.info("{}\tcron", System.currentTimeMillis()/100);
    }
}