package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 定时作业结构
 */
@Data
public class CronJobId {

    /**
     * 主键
     */
    @JsonProperty("cron_id")
    private long cronId;

}
