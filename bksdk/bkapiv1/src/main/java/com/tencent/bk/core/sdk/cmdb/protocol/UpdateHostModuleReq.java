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
public class UpdateHostModuleReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("ip")
    private String ip; //主机内网IP

    @JsonProperty("plat_id")
    private int platId; //主机子网ID

    @JsonProperty("dst_module_id")
    private String destModuleId; //目标模块ID，多个以逗号分隔

}