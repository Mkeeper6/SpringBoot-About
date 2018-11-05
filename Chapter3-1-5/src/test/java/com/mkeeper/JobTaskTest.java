package com.mkeeper;

import com.mkeeper.mapper.JobTaskMapper;
import com.mkeeper.model.JobTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTaskTest {
    @Resource
    private JobTaskMapper jobTaskMapper;

    @Test
    public void addJob(){
        //生成几个任务，第一任务在三分钟之后
        Long unixTime = System.currentTimeMillis() + 60000;
        JobTask task = new JobTask("test-msg-1", 0, unixTime);
        jobTaskMapper.insert(task);
        unixTime += 60000;
        task = new JobTask("test-msg-2", 0, unixTime);
        jobTaskMapper.insert(task);
        unixTime += 60000;
        task = new JobTask("test-msg-3", 0, unixTime);
        jobTaskMapper.insert(task);
        unixTime += 60000;
        task = new JobTask("test-msg-4", 0, unixTime);
        jobTaskMapper.insert(task);

    }

    @Test
    public void find(){
        List<JobTask> list = jobTaskMapper.findAllUnDoTask();
        log.info(list.size() + " ");
    }

}
