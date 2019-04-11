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
public class GetTaskListReq extends ESBReq {

    /**
     * 业务ID
     */
    @JsonProperty("app_id")
    private int applicationId;
    /**
     * 作业的名称
     */
    @JsonProperty("name")
    private String name;
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