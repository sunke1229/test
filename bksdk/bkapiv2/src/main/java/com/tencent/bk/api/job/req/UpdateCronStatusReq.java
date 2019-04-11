package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCronStatusReq extends ApiReq {
    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 定时任务ID，
     * 更新定时任务时，必须传这个值
     */
    @JsonProperty("cron_id")
    private long cronId;

    /**
     * 定时作业的状态： 1.已启动 2.已暂停、3.已完成
     */
    @JsonProperty("cron_status")
    private int cronStatus;
}