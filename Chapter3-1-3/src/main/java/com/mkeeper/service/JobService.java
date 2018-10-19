package com.mkeeper.service;

import com.mkeeper.dao.JobMapper;
import com.mkeeper.exception.ServiceException;
import com.mkeeper.model.ScheduleJob;
import com.mkeeper.utils.ScheduleUtil;
import org.quartz.Scheduler;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobService {
    @Resource
    private JobMapper jobMapper;

    @Resource
    private Scheduler scheduler;

    public List<ScheduleJob> getAllEnableJob() {
        return jobMapper.getAllEnableJob();
    }

    public ScheduleJob select(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = jobMapper.select(jobId);
        if (scheduleJob == null) {
            throw new ServiceException("ScheduleJob:" + jobId + " not found");
        }
        return scheduleJob;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public ScheduleJob update(Long jobId, ScheduleJob scheduleJob) throws ServiceException {

        if (jobMapper.update(scheduleJob) <= 0) {
            throw new ServiceException("Update product:" + jobId + "failed");
        }

        ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);

        return scheduleJob;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean add(ScheduleJob scheduleJob) throws ServiceException {
        Integer num = jobMapper.insert(scheduleJob);
        if (num <= 0) {
            throw new ServiceException("Add product failed");
        }

        ScheduleUtil.createScheduleJob(scheduler, scheduleJob);

        return true;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean delete(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = select(jobId);

        Integer num = jobMapper.delete(jobId);
        if (num <= 0) {
            throw new ServiceException("Delete product:" + jobId + "failed");
        }

        ScheduleUtil.deleteJob(scheduler, scheduleJob);

        return true;
    }

    public List<ScheduleJob> getAllJob() {
        return jobMapper.getAllJob();
    }

    public boolean resume(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, false);
        ScheduleUtil.resumeJob(scheduler, scheduleJob);
        return true;
    }

    public boolean pause(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, true);
        ScheduleUtil.pauseJob(scheduler, scheduleJob);
        return true;
    }

    public boolean run(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, false);
        ScheduleUtil.run(scheduler, scheduleJob);
        return true;
    }

    private ScheduleJob updateScheduleJobStatus(Long jobId, Boolean isPause) throws ServiceException {
        ScheduleJob scheduleJob = select(jobId);
        scheduleJob.setPause(isPause);
        update(scheduleJob.getId(), scheduleJob);
        return scheduleJob;
    }
}
