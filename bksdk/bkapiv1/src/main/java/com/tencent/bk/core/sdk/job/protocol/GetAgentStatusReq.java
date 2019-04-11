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
public class GetAgentStatusReq extends ESBReq {

    /**
     * 业务ID
     */
    @JsonProperty("app_id")
    private int applicationId;
    /**
     * IP信息，每项条目包含信息见下面参数描述
     * {
     * "ip": "10.1.1.1",
     * "plat_id": 1,
     * }
     */
    @JsonProperty("ip_infos")
    private List<Map<String, Object>> ipList;
}