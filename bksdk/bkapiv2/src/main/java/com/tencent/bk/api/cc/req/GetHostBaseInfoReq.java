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
 *     "bk_host_id": 123,
 * }
 */
@Getter
@Setter
public class GetHostBaseInfoReq extends ApiReq {
    /**
     * 可选：开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;
    /**
     * 必填：	主机ID
     */
    @JsonProperty("bk_host_id")
    private int bkHostId;
}
