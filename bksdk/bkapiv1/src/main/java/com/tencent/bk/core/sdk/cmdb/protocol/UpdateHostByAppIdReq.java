/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.cmdb.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UpdateHostByAppIdReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("plat_id")
    private int platId; //主机子网ID

    @JsonProperty("proxy_list")
    private List<ProxyIp> proxyList; //主机内网IP

    @Getter@Setter
    public static class ProxyIp {
        @JsonProperty("inner_ip")
        private String ip;
        @JsonProperty("outer_ip")
        private String outerIp;
    }
}
