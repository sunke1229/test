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
 *     "bk_set_id": 1,
 *     "bk_module_id": 1
 * }
 */
@Getter
@Setter
public class DeleteModuleReq extends ApiReq {
    /**
     * 开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;

    @JsonProperty("bk_set_id")
    private int bkSetId;

    @JsonProperty("bk_module_id")
    private int bkModuleId;
}
