package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * {
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_biz_id": 1,
 *     "bk_host_id": [
 *         9,
 *         10
 *     ]
 * }
 */
@Getter
@Setter
public class TransferHostToResourceModule extends ApiReq {
    /**
     * 必填：业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 必填：	主机ID列表
     */
    @JsonProperty("bk_host_id")
    private Set<String> bkHostIds;
}
