package com.mkeeper.model;

import java.io.Serializable;

/**
 * job_task
 * @author 
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}