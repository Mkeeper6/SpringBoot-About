package com.mkeeper.dao;

import com.mkeeper.model.JobTask;

import java.util.List;

public interface TaskMapper {
    JobTask findById(Integer id);

    void update(JobTask jobTask);

    List<JobTask> findAllUnDoTask();
}
