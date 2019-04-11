/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.job.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class ExecuteTaskExtReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId;
    /**
     * 作业ID
     */
    @JsonProperty("task_id")
    private int taskId;
    /**
     * 全局变量信息，作业包含的全局变量和类型可以通过接口“查询作业模板详情”(get_task_detail)获取
     * [{
     * "id": 436,
     * "ipList": "1:10.0.0.1",
     * },
     * {
     * "id": 437,
     * "value": "newValue",
     * }]
     */
    @JsonProperty("global_var")
    private List<Map<String, Object>> globalVar;
}