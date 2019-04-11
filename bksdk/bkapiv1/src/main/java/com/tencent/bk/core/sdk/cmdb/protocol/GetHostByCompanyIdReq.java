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
public class GetHostByCompanyIdReq extends ESBReq {

    @JsonProperty("company_id")
    private int companyId; //开发商ID

    @JsonProperty("ip")
    private String ip; //主机ip

    @JsonProperty("plat_id")
    private int platId; //子网ID
}
