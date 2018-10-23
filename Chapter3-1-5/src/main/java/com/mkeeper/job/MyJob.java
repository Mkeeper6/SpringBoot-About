package com.mkeeper.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        //打印出任务相关信息，JobParameter用于传递任务的ID
        log.info("任务名：{}, 片数：{}, id={}", shardingContext.getJobName(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getJobParameter());
    }
}
