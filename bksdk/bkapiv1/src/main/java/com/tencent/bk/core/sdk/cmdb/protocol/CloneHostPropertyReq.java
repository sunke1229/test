/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.cmdb.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CloneHostPropertyReq extends ESBReq {

    @JsonProperty("plat_name")
    private String platName;

    @JsonProperty("app_id")
    private int applicationId; // 业务ID

    @JsonProperty("plat_id")
    private int platId; // 子网ID

    @JsonProperty("org_ip")
    private String originIp; // 主机

    @JsonProperty("dst_ip")
    private String destIp; // 目标主机
}
