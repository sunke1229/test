/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetIpAndProxyDto implements Serializable {

    @JsonProperty("proxy_list")
    private List<String> proxyList;

    @JsonProperty("ip_list")
    private List<String> ipList;

    @JsonProperty("invalid_ips")
    private List<String> invalidIps;

}
