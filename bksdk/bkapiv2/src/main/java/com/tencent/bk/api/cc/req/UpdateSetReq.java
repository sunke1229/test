package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * {
 * "bk_app_code": "esb_test",
 * "bk_app_secret": "xxx",
 * "bk_token": "xxx",
 * "bk_biz_id": 1,
 * "bk_set_id": 1,
 * "data": {
 * "bk_set_name": "test"
 * }
 * }
 */
@Getter
@Setter
public class UpdateSetReq extends ApiReq {

    /**
     * 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 集群id
     */
    @JsonProperty("bk_set_id")
    private int bkSetId;

    /**
     * 模块数据
     * <p>
     * 字段	            类型  	必选	    描述
     * bk_parent_id	    int	    否	    父节点的ID
     * bk_set_name	    string	否	    集群名字
     * <p>
     * 注意：用户自定义的字段也可以作为参数传入
     */
    private Map<String, Object> data;
}
