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
public class FastExecuteScriptReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId;
    /**
     * 执行脚本步骤的脚本内容，base64编码后的内容
     */
    @JsonProperty("content")
    private String base64Content;

    /**
     * 可选 脚本执行超时时间，范围60~72000，默认1000
     */
    @JsonProperty("script_timeout")
    private int scriptTimeout;

    /**
     * 脚本参数 可选
     */
    @JsonProperty("script_param")
    private String scriptParam;

    /**
     * 脚本类型：1(shell脚本)、2(bat脚本)、3(perl脚本)、4(python脚本)、5(Powershell脚本)
     */
    private int type;

    /**
     * 可选 目标机器，包含以下内容：
     * [{
     * "ip": "10.1.1.1",
     * "source": 1
     * }]
     */
    @JsonProperty("ip_list")
    private List<Map<String, Object>> ipList;

    /**
     * 目标机器分组ID；server_set_id和ip_list至少一个必须存在，如果同时存在，则以server_set_id为准
     */
    @JsonProperty("server_set_id")
    private int serverSetId;

    /**
     * 目标机器账户名
     */
    private String account;

    /**
     * 是否敏感参数: 1是, 0不是(默认为0)
     */
    @JsonProperty("is_param_sensitive")
    private int isParamSensitive = 0;
}