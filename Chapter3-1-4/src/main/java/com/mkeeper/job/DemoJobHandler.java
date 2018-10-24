package com.mkeeper.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 任务Handler示例（Bean模式）
 *
 */
@JobHandler(value="demoJobHandler")
@Component
@Slf4j
public class DemoJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) {
        log.info("XXL-JOB, Hello World.");

        return SUCCESS;
    }

}
