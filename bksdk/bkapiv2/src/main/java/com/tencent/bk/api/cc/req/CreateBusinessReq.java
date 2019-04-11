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
 * "data": {
 * "bk_biz_name": "cc_app_test",
 * "bk_biz_maintainer": "admin",
 * "bk_biz_productor": "admin",
 * "bk_biz_developer": "admin",
 * "bk_biz_tester": "admin",
 * "time_zone": "Asia/Shanghai"
 * }
 * }
 */
@Getter
@Setter
public class CreateBusinessReq extends ApiReq {
    /**
     * 开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;
    /**
     * 字段	                类型	    必选	    描述
     * bk_biz_name	        string	是	    业务名
     * bk_biz_maintainer	string	是	    运维人员
     * bk_biz_productor	    string	是	    产品人员
     * bk_biz_developer	    string	是	    开发人员
     * bk_biz_tester	    string	是	    测试人员
     * time_zone	        string	是	    时区
     *
     * 注意：此处的输入参数仅对必填以及系统内置的参数做了说明，其余需要填写的参数取决于用户自己定义的属性字段。
     */
    private Map<String,Object> data;

}
