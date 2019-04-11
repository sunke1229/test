package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 定时作业结构
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CronJob extends CronJobId {

    /**
     * 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 执行作业id
     */
    @JsonProperty("bk_job_id")
    private long bkJobId;

    /**
     * 名称
     */
    @JsonProperty("cron_name")
    private String cronName;

    /**
     * 描述
     */
    private String description;

    /**
     * 作业名称
     */
    @JsonProperty("job_name")
    private String jobName;

    /**
     * 定时表达式
     */
    @JsonProperty("cron_expression")
    private String cronExpression;

    /**
     * 状态：1.已启动、2.已暂停、3.已完成
     */
    @JsonProperty("cron_status")
    private int cronStatus;

    /**
     * 创建者
     */
    private String creater;
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;
    /**
     * 最后修改人
     */
    @JsonProperty("last_modify_user")
    private String lastModifyUser;
    /**
     * 最后修改时间
     */
    @JsonProperty("last_modify_time")
    private Date lastModifyTime;
}
