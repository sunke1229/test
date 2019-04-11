package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.cc.model.CustomQueryConditions;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 * "bk_app_code": "esb_test",
 * "bk_app_secret": "xxx",
 * "bk_token": "xxx",
 * "bk_biz_id": 1,
 * "info": "{\"condition\":[{\"bk_obj_id\":\"biz\",\"condition\":[{\"field\":\"default\",\"operator\":\"$ne\",\"value\":1}],\"fields\":[]},{\"bk_obj_id\":\"set\",\"condition\":[],\"fields\":[]},{\"bk_obj_id\":\"module\",\"condition\":[],\"fields\":[]},{\"bk_obj_id\":\"host\",\"condition\":[{\"field\":\"bk_host_innerip\",\"operator\":\"$eq\",\"value\":\"127.0.0.1\"}],\"fields\":[\"bk_host_innerip\",\"bk_host_outerip\",\"bk_agent_status\"]}]}",
 * "name": "api1"
 * }
 */
@Setter@Getter
public class UpdateCustomQueryReq extends ApiReq {
    /**
     * 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * id
     */
    private String id;
    /**
     * 收藏的名称
     */
    private String name;

    /**
     * 通用查询条件, API会帮助转换成json
     */
    @JsonIgnore
    private CustomQueryConditions conditions;

    /**
     * 此字段不需要用户填写，直接通过conditions字段设置，SDK会转换
     */
    @JsonProperty("info")
    private String conditionJson;
}
