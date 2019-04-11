/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 定时作业信息
 */
@Getter
@Setter
public class CronTaskDto implements Serializable {
    /**
     * 定时任务ID
     */
    private int id;
    /**
     * 业务ID
     */
    @JsonProperty("appId")
    private int applicationId;

    /**
     * 定时规则来源， 0:界面配置；1:用户输入
     */
    private int type;

    /**
     * 定时规则表达式
     */
    private String cronExpression;
    /**
     * 定时要执行的任务ID
     */
    private int taskId;
    /**
     * 定时任务名称
     */
    private String name;
    /**
     * 定时要执行的任务名称
     */
    private String taskName;

    private String creater;

    private String createTime;

    private String lastModifyUser;

    private String lastModifyTime;

    private String des;
}
