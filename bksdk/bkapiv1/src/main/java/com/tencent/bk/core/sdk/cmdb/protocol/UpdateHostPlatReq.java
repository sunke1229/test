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
public class UpdateHostPlatReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("src_plat_id")
    private int srcPlatId; //主机现子网ID

    @JsonProperty("dst_plat_id")
    private int destPlatId; //变更后的子网ID

    @JsonProperty("ip")
    private String ip; //主机内网IP

}