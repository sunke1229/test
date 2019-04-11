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
 *     "bk_supplier_id": 0,
 *     "bk_biz_id": 1
 * }
 */
@Getter
@Setter
public class DeleteCustomQueryReq extends ApiReq {

    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 自定义API查询ID
     */
    private int id;
}
