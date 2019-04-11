/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.job.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveCronTaskReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId;

    @JsonProperty("crontab_task_id")
    private int cronTaskId;

    @JsonProperty("cron_expression")
    private String cronExpression;

    @JsonProperty("task_id")
    private int taskId;

    @JsonProperty("name")
    private String name;


}