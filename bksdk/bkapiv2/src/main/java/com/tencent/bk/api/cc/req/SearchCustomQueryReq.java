package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 *{
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_biz_id": 1,
 *     "condition": {
 *         "name": "api1"
 *     },
 *     "start": 0,
 *     "limit": 200
 *}
 */
@Getter
@Setter
public class SearchCustomQueryReq extends ApiReq {

    /**
     * 	业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 查询条件，参数为业务的任意属性，如果不写代表搜索全部数据
     */
    private Map<String, Object> condition;
    /**
     * 	记录开始位置 0开始
     */
    private int start;
    /**
     * 每页限制条数,最大200
     */
    private int limit;
}
