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
 * 作业步骤实例
 * {
 * "totalTime": 0,
 * "failIPNum": 0,
 * "text": null,
 * "successIPNum": 2,
 * "isPause": 0,
 * "operator": "2797261603",
 * "stepInstanceId": 75,
 * "taskInstanceId": 65,
 * "type": 1,
 * "badIPNum": 0,
 * "status": 3,
 * "stepId": -1,
 * "blockName": "执行脚本-20158915516182",
 * "operationList": [],
 * "startTime": "2015-09-09 15:05:32",
 * "appId": 1,
 * "totalIPNum": 2,
 * "ord": 1,
 * "createTime": "2015-09-09 15:05:31",
 * "name": "执行脚本-20158915516182",
 * "blockOrd": 1,
 * "retryCount": 0,
 * "endTime": "2015-09-09 15:05:32",
 * "runIPNum": 2
 * }
 */
@Getter
@Setter
public class StepInstanceDto implements Serializable {

    private double totalTime;

    private int failIPNum;

    private String text;

    private int successIPNum;

    private int isPause;

    private String operator;

    private int stepInstanceId;

    private int taskInstanceId;

    private int type;

    private int badIPNum;

    private int status;

    private int stepId;

    private String blockName;

    private List<String> operationList;

    private String startTime;

    @JsonProperty("appId")
    private int applicationId;

    private int totalIPNum;

    private int ord;

    private String createTime;

    private String name;

    private int blockOrd;

    private int retryCount;

    private String endTime;

    private int runIPNum;
}