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
 * 作业的执行结果
 * {
 * "isFinished": true,
 * "taskInstance":
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
 * },
 * "blocks": [
 * {
 * "type": 1,
 * "stepInstances": [
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
 * ],
 * "blockOrd": 1,
 * "blockName": "执行脚本-20158915516182"
 * }
 * ]
 * }
 */
@Getter
@Setter
public class TaskResultDto implements Serializable {

    @JsonProperty("isFinished")
    private boolean finished;

    private TaskInstanceDto taskInstance;

    private List<BlockDto> blocks;

}

