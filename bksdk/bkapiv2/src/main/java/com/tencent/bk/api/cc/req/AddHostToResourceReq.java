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
 * "host_info": {
 * "0": {
 * "bk_host_innerip": "10.0.0.1",
 * "bk_cloud_id": 0,
 * "import_from": "api"
 * }
 * }
 * }
 */
@Getter
@Setter
public class AddHostToResourceReq extends ApiReq {
    /**
     * 可选: 开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;
    /**
     * 可选: 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 必选: 主机信息
     */
    @JsonProperty("host_info")
    private Map<String, ImportHostInfo> hostInfoMap;

    @Getter
    @Setter
    public static class ImportHostInfo {
        /**
         * 主机内网ip
         */
        @JsonProperty("bk_host_innerip")
        private String ip;
        /**
         * 主机导入来源，默认值: api
         */
        @JsonProperty("bk_cloud_id")
        private int bkCloudId;
        /**
         * 云区域ID
         */
        @JsonProperty("import_from")
        private String importFrom = "api";
    }
}
