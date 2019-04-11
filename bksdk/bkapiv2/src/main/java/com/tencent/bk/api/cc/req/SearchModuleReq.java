package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.cc.model.Page;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

/**
 *{
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "fields": [
 *         "bk_module_name"
 *     ],
 *     "condition": {
 *         "bk_module_name": "test"
 *     },
 *     "page": {
 *         "start": 0,
 *         "limit": 10
 *     }
 * }
 */
@Getter
@Setter
public class SearchModuleReq extends ApiReq {
    /**
     * 可选：开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;
    /**
     * 必填：业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 必填：集群id
     */
    @JsonProperty("bk_set_id")
    private int bkSetId;
    /**
     * 必选：指定查询的字段，参数为业务的任意属性，如果不填写字段信息，系统会返回业务的所有字段
     */
    private Set<String> fields;
    /**
     * 必选：查询条件，参数为业务的任意属性，如果不写代表搜索全部数据
     */
    private Map<String, Object> condition;
    /**
     * 必选：分页条件
     */
    private Page page;
}
