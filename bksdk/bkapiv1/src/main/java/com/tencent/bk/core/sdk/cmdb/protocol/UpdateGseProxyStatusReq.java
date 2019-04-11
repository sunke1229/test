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
public class UpdateGseProxyStatusReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("plat_id")
    private int platId; //主机子网ID

    @JsonProperty("ip")
    private String ip; //主机内网IP

    @JsonProperty("status")
    private int status; //状态，包含1: 设置gse proxy, 0: 删除gse proxy

}
