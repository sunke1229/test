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
public class GetIpAndProxyByCompany extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("plat_id")
    private int platId; //子网ID

    @JsonProperty("ip_list")
    private String ipList; //内网IP列表，多个以逗号分隔

}
