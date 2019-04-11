/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 作业实例
 * {
 * "status": 3,
 * "totalTime": 0,
 * "endTime": "2015-09-09 15:05:32",
 * "startTime": "2015-09-09 15:05:32",
 * "operationList": [],
 * "startWay": 1,
 * "taskId": -1,
 * "appId": 1,
 * "operator": "2797261603",
 * "taskInstanceId": 65,
 * "currentStepId": 75,
 * "createTime": "2015-09-09 15:05:31",
 * "name": "执行脚本-20158915516182"
 * }
 */
@Getter
@Setter
public class TaskInstanceDto implements Serializable {

    private int status;

    private double totalTime;

    private String endTime;

    private String startTime;

    private List<String> operationList;

    private int startWay;

    private int taskId;

    @JsonProperty("appId")
    private int applicationId;

    private String operator;

    private int taskInstanceId;

    private int currentStepId;

    private String createTime;

    private String name;
}