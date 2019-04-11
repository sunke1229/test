/*
 *  Copyright (c) 2018 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.api.login.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * 批量获取用户信息
 */
@Setter
@Getter
public class GetBatchUserReq extends ApiReq {
    /**
     * 用户名列表
     */
    @JsonProperty("bk_username_list")
    private String userNameList;

}
