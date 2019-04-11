package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * {
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_supplier_id": 0,
 *     "bk_biz_id": 1,
 *     "data": {
 *         "bk_parent_id": 1,
 *         "bk_set_name": "test-set",
 *         "bk_set_desc": "test-set",
 *         "bk_capacity": 1000,
 *         "description": "description"
 *     }
 * }
 */
@Getter
@Setter
public class CreateSetReq extends ApiReq {
    /**
     * 开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;
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
     * 集群数据
     *
     * 字段	        类型	    必选	    描述
     * bk_parent_id	int	    是	    父实例的ID
     * bk_set_name	string	是	    集群名字
     * default	    int	    否	    0-普通集群，1-内置模块集合，默认为0
     *
     * 注意：其它需要的字段由模型定义
     */
    private Map<String, Object> data;
}
