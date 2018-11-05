package com.mkeeper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * job_task
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTask implements Serializable {
    private Integer id;

    private String content;

    /**
     * 0-未执行
     1-已执行
     */
    private Integer status;

    private Long updateTime;

    private static final long serialVersionUID = 1L;


    public JobTask(String content, Integer status, Long updateTime) {
        this.content = content;
        this.status = status;
        this.updateTime = updateTime;
    }
}