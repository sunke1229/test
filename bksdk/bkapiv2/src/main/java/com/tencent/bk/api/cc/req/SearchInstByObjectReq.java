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
 *     "bk_obj_id": "plat",
 *     "fields": [
 *     ],
 *     "condition": {
 *     },
 *     "page": {
 *         "start": 0,
 *         "limit": 10,
 *         "sort": ""
 *     }
 *}
 */
@Getter
@Setter
public class SearchInstByObjectReq extends ApiReq {

    /**
     * 开发商帐号，可选
     */
    @JsonProperty("bk_supplier_account")
    private int bkSupplierAccount;

    /**
     * 必填：	自定义模型ID，查询区域时为plat
     */
    @JsonProperty("bk_obj_id")
    private String bkObjId;
    /**
     * 可选：指定查询的字段，参数为业务的任意属性，如果不填写字段信息，系统会返回业务的所有字段
     */
    private Set<String> fields;
    /**
     * 可选：查询条件，参数为业务的任意属性，如果不写代表搜索全部数据
     */
    private Map<String, Object> condition;
    /**
     * 可选：分页条件
     */
    private Page page;
}
