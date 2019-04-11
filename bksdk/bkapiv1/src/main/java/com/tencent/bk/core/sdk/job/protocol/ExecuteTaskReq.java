/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.job.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.dto.job.StepDto;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExecuteTaskReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId;

    @JsonProperty("task_id")
    private int taskId;

    @JsonProperty("Steps")
    private List<StepDto> Steps;
}