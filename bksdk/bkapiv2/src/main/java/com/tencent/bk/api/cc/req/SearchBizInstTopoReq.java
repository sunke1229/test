package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 *  "bk_app_code": "esb_test",
 *  "bk_app_secret": "xxx",
 *  "bk_token": "xxx",
 *  "bk_biz_id": 1
 * }
 */
@Getter
@Setter
public class SearchBizInstTopoReq extends ApiReq {
    /**
     * 必填 业务id，
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 开发商帐号，可选
     */
    @JsonProperty("bk_supplier_account")
    private int bkSupplierAccount;
    /**
     * 可选， 拓扑的层级索引，索引取值从0开始，默认值为2，当设置为 -1 的时候会读取完整的业务实例拓扑
     */
    private int level;
}
