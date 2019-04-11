/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 作业步骤中的节点分组
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
 */
@Getter
@Setter
public class BlockDto implements Serializable {

    private int type;

    private List<StepInstanceDto> stepInstances;
    private int blockOrd;

    private String blockName;
}
