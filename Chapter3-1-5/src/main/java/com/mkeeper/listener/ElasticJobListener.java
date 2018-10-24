package com.mkeeper.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import com.mkeeper.mapper.JobTaskMapper;
import com.mkeeper.model.JobTask;

import javax.annotation.Resource;

/**
 *    分布式的任务监听器，如果任务有分片，分布式监听器会在总的任务开始前执行一次，结束时执行一次
 *
 * @author Mkeeper
 * @create 2018/10/23 20:09
 */
public class ElasticJobListener extends AbstractDistributeOnceElasticJobListener {

    @Resource
    private JobTaskMapper jobTaskMapper;

    public ElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        //任务执行完成后更新状态为已执行
        JobTask jobTask = jobTaskMapper.selectByPrimaryKey(Integer.valueOf(shardingContexts.getJobParameter()));
        jobTask.setStatus(1);
        jobTaskMapper.updateByPrimaryKeySelective(jobTask);
    }
}
