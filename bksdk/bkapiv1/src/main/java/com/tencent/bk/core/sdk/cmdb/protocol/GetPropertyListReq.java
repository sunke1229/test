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
public class GetPropertyListReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId; //业务ID

    @JsonProperty("type")
    private String type;//    type 可选	string 属性类型，包含1:业务，2:集群，3:模块，4:主机
}
