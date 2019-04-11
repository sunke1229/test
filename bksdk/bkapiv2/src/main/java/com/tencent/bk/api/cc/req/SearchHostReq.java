package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.cc.model.CustomQueryCondition;
import com.tencent.bk.api.cc.model.IpCondition;
import com.tencent.bk.api.cc.model.Page;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 *{
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "ip": {
 *         "data": [],
 *         "exact": 1,
 *         "flag": "bk_host_innerip|bk_host_outerip"
 *     },
 *     "condition": [
 *         {
 *             "bk_obj_id": "host",
 *             "fields": [],
 *             "condition": []
 *         },
 *         {
 *             "bk_obj_id": "object",
 *             "fields": [],
 *             "condition": [
 *                 {
 *                     "field": "bk_inst_id",
 *                     "operator": "$eq",
 *                     "value": 76
 *                 }
 *             ]
 *         }
 *     ],
 *     "page": {
 *         "start": 0,
 *         "limit": 10,
 *         "sort": "bk_host_name"
 *     },
 *     "pattern": ""
 * }
 */
@Getter
@Setter
public class SearchHostReq extends ApiReq {
    /**
     * 可选：主机ip列表
     */
    @JsonProperty("ip")
    private IpCondition ip;
    /**
     * 可选：	组合条件
     */
    private Set<CustomQueryCondition> condition;
    /**
     * 可选：分页条件
     */
    private Page page;
    /**
     * 可选: 按表达式搜索
     */
    private String pattern;
}
