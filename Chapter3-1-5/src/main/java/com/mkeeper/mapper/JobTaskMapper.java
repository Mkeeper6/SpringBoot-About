package com.mkeeper.mapper;

import com.mkeeper.model.JobTask;

import java.util.List;

public interface JobTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobTask record);

    int insertSelective(JobTask record);

    JobTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobTask record);

    int updateByPrimaryKey(JobTask record);

    List<JobTask> findAllUnDoTask();
}