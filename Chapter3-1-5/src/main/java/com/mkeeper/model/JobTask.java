package com.mkeeper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobTask {
    private Long id;
    private String content;
    /**
     * 0-未执行
     * 1-已执行
     */
    private Integer status;
    private Long sendTime;
}

