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
 * "bk_supplier_id": 0,
 * "bk_biz_id": 1,
 * "data": {
 * "bk_biz_name": "cc_app_test",
 * "bk_biz_maintainer": "admin",
 * "bk_biz_productor": "admin",
 * "bk_biz_developer": "admin",
 * "bk_biz_tester": "admin",
 * }
 * }
 */
@Getter
@Setter
public class UpdateBusinessReq extends ApiReq {

    /**
     * 可选：开发商ID
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;

    /**
     * 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 字段	                类型	    必选	    描述
     * bk_biz_name	        string	否	    业务名
     * bk_biz_maintainer	string	否	    运维人员
     * bk_biz_productor	    string	否	    产品人员
     * bk_biz_developer	    string	否	    开发人员
     * bk_biz_tester	    string	否	    测试人员
     * time_zone	        string	否	    时区
     * <p>
     * 注意：此处的输入参数仅对必填以及系统内置的参数做了说明，其余需要填写的参数取决于用户自己定义的属性字段。
     */
    private Map<String, Object> data;


}
