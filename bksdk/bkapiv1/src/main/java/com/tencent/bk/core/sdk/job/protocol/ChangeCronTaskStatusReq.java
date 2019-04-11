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
public class ChangeCronTaskStatusReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务 ID

    @JsonProperty("status")
    private int status; //    作业状态，1.启动、2.暂停

    @JsonProperty("crontab_task_id")
    private int cronTaskId;  //     定时任务ID

}