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
public class QueryCronTaskReq extends ESBReq {

    /**
     * 业务ID
     */
    @JsonProperty("app_id")
    private int applicationId;
    /**
     * 定时任务ID，如果存在，则忽略其他筛选条件，只查询这个指定的作业信息
     */
    @JsonProperty("crontab_task_id")
    private int cronTaskId;
    /**
     * 定时作业的名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 作业的状态：1.已启动、2.已暂停、3.已完成
     */
    @JsonProperty("status")
    private int status;
    /**
     * 作业创建人
     */
    @JsonProperty("creater")
    private String creater;
    /**
     * 最后修改人
     */
    @JsonProperty("last_modify_user")
    private String lastModifyUser;
    /**
     * 创建起始时间，YYYY-MM-DD格式
     */
    @JsonProperty("create_time_start")
    private String createTimeStart;
    /**
     * 创建结束时间，YYYY-MM-DD格式
     */
    @JsonProperty("create_time_end")
    private String createTimeEnd;
    /**
     * 最后修改起始时间，YYYY-MM-DD格式
     */
    @JsonProperty("last_modify_time_start")
    private String lastModifyTimeStart;
    /**
     * 最后修改结束时间，YYYY-MM-DD格式
     */
    @JsonProperty("last_modify_time_end")
    private String lastModifyTimeEnd;
}