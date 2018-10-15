package com.mkeeper.controller;

import com.mkeeper.common.R;
import com.mkeeper.exception.ServiceException;
import com.mkeeper.model.ScheduleJob;
import com.mkeeper.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public R getAllJob() {
        return R.isOk().data(jobService.getAllJob());
    }

    @GetMapping("/{id}")
    public R getJob(@PathVariable("id") Long jobId) throws ServiceException {
        return R.isOk().data(jobService.select(jobId));
    }

    @PutMapping("/update/{id}")
    public R updateJob(@PathVariable("id") Long jobId, @RequestBody ScheduleJob newScheduleJob) throws ServiceException {
        return R.isOk().data(jobService.update(jobId, newScheduleJob));
    }

    @DeleteMapping("/delete/{id}")
    public R deleteJob(@PathVariable("id") Long jobId) throws ServiceException {
        return R.isOk().data(jobService.delete(jobId));
    }

    @PostMapping("/add")
    public R saveJob(@RequestBody ScheduleJob newScheduleJob) throws ServiceException {
        return R.isOk().data(jobService.add(newScheduleJob));
    }


    @GetMapping("/run/{id}")
    public R runJob(@PathVariable("id") Long jobId) throws ServiceException {
        return R.isOk().data(jobService.run(jobId));
    }


    @GetMapping("/pause/{id}")
    public R pauseJob(@PathVariable("id") Long jobId) throws ServiceException {
        return R.isOk().data(jobService.pause(jobId));
    }

    @GetMapping("/resume/{id}")
    public R resumeJob(@PathVariable("id") Long jobId) throws ServiceException {
        return R.isOk().data(jobService.resume(jobId));
    }
}

