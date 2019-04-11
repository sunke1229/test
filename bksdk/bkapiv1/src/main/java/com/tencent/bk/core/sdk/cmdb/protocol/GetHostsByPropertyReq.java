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
public class GetHostsByPropertyReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("set_id")
    private String setId; //大区ID，多个以逗号分隔

    @JsonProperty("set_envi_type")
    private String setEnvironmentType; //Set 环境类型，多个以逗号分隔

    @JsonProperty("set_service_status")
    private String setServiceStatus; //Set开放状态，多个以逗号分隔

    @JsonProperty("module_name")
    private String moduleName; //模块名称，多个以逗号分隔


}
