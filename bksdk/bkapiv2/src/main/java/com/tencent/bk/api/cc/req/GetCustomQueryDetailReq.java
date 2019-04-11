package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_biz_id": 1,
 *     "id": "xxx"
 * }
 */
@Getter
@Setter
public class GetCustomQueryDetailReq extends ApiReq {
    /**
     * 	业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 主键ID
     */
    @JsonProperty("id")
    private String customQueryId;
}
