package com.mkeeper.service;

import com.mkeeper.dao.JobDao;
import com.mkeeper.exception.ServiceException;
import com.mkeeper.model.ScheduleJob;
import com.mkeeper.utils.ScheduleUtil;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobService {

    @Resource
    private JobDao jobDao;

    @Resource
    private Scheduler scheduler;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<ScheduleJob> getAllEnableJob() {
        return jobDao.getAllEnableJob();
    }

    public ScheduleJob select(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = jobDao.select(jobId);
        if (scheduleJob == null) {
            throw new ServiceException("ScheduleJob:" + jobId + " not found");
        }
        return scheduleJob;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public ScheduleJob update(Long jobId, ScheduleJob scheduleJob) throws ServiceException {

        if (jobDao.update(scheduleJob) <= 0) {
            throw new ServiceException("Update product:" + jobId + "failed");
        }

        ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);

        return scheduleJob;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean add(ScheduleJob scheduleJob) throws ServiceException {
        Integer num = jobDao.insert(scheduleJob);
        if (num <= 0) {
            throw new ServiceException("Add product failed");
        }

        ScheduleUtil.createScheduleJob(scheduler, scheduleJob);

        return true;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean delete(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = select(jobId);

        Integer num = jobDao.delete(jobId);
        if (num <= 0) {
            throw new ServiceException("Delete product:" + jobId + "failed");
        }

        ScheduleUtil.deleteJob(scheduler, scheduleJob);

        return true;
    }

    public List<ScheduleJob> getAllJob() {
        return jobDao.getAllJob();
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
