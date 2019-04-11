package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveCronReq extends ApiReq {

    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 必填：要定时执行的作业的作业ID
     */
    @JsonProperty("bk_job_id")
    private long bkJobId;

    /**
     * 定时任务ID，
     * 更新定时任务时，必须传这个值
     */
    @JsonProperty("cron_id")
    private long cronId;
    /**
     * 定时作业名称
     * 定时作业名称.新建时必填，修改时选填
     */
    @JsonProperty("cron_name")
    private String cronName;
    /**
     * 定时任务crontab的定时规则. 新建时必填，修改时选填.
     * 各自段含义为：秒 分 时 日 月 周 年（可选），
     * 如: 0 0/5 * * * ? 表示每5分钟执行一次
     */
    @JsonProperty("cron_expression")
    private String cronExpression;
}