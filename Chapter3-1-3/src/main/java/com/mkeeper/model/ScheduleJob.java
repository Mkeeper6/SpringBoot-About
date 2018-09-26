package com.mkeeper.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ScheduleJob implements Serializable {

    private static final Long serialVersionUID = 1435515995276255188L;

    private Long id;

    private String className;

    private String cronExpression;

    private String jobName;

    private String jobGroup;

    private String triggerName;

    private String triggerGroup;

    private Boolean pause;

    private Boolean enable;

    private String description;

    private Date createTime;

    private Date lastUpdateTime;

}

