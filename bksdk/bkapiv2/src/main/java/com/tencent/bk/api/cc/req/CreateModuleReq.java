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
 *     "bk_set_id": 10,
 *     "data": {
 *         "bk_parent_id": 10,
 *         "bk_module_name": "test"
 *     }
 * }
 */
@Getter
@Setter
public class CreateModuleReq extends ApiReq {
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
     * 	业务数据
     *
     * 字段	            类型	    必选	    描述
     * bk_parent_id	    int	    是	    父实例节点的ID，当前实例节点的上一级实例节点，
     *                                  在拓扑结构中对于module一般指的是set的bk_set_id
     * bk_module_name	string	是	    模块名
     *
     * 注意：其它需要的字段由模型定义
     */
    private Map<String, Object> data;
}
