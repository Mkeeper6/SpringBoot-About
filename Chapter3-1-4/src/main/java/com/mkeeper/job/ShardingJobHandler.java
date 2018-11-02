package com.mkeeper.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;
import org.springframework.stereotype.Component;


/**
 * 分片广播任务
 */
@JobHandler(value="shardingJobHandler")
@Component
public class ShardingJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) {

        // 分片参数
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        XxlJobLogger.log("分片参数：当前分片序号 = {0}, 总分片数 = {1}", shardingVO.getIndex(), shardingVO.getTotal());

        // 业务逻辑
        for (int i = 0; i < shardingVO.getTotal(); i++) {
            if (i == shardingVO.getIndex()) {
                XxlJobLogger.log("第 {0} 片, 命中分片开始处理", i);
            } else {
                XxlJobLogger.log("第 {0} 片, 忽略", i);
            }
        }

        return SUCCESS;
    }
}
