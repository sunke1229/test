package com.tencent.bk.api.cc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

/**
 * {
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_host_id": "1,2,3",
 *     "data": {
 *         "bk_host_name": "test"
 *     }
 * }
 */
@Getter
@Setter
public class UpdateHostReq extends ApiReq {

    /**
     * 业务id
     */
    @JsonProperty("bk_host_id")
    private Set<String> bkHostIds;

    /**
     * 字段	                类型	    必选	    描述
     * bk_host_name	        string	否	    主机名
     * <p>
     * 注意：输入的字段为主机定义的属性
     */
    private Map<String, Object> data;


}
