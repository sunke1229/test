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
public class GetAppByRoleReq extends ESBReq {

    /**
     * 用户角色，多个以逗号分隔，可选值为：Maintainers,ProductPm,Cooperation等
     */
    @JsonProperty("user_role")
    private String userRoles;
}
