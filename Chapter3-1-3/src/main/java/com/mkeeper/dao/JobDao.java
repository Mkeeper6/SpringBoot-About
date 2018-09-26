package com.mkeeper.dao;

import com.mkeeper.model.ScheduleJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDao {
    ScheduleJob select(long id);

    Integer update(ScheduleJob scheduleJob);

    Integer insert(ScheduleJob scheduleJob);

    Integer delete(Long productId);

    List<ScheduleJob> getAllJob();

    List<ScheduleJob> getAllEnableJob();
}