package com.tencent.bk.api.gse.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.gse.model.Host;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * {
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_supplier_id": 0,
 *     "hosts": [
 *         {
 *             "ip": "10.0.0.1",
 *             "bk_cloud_id": 0
 *         }
 *     ]
 * }
 */
@Getter@Setter
public class GetAgentStatusReq extends ApiReq {

    /**
     * 开发商ID CompanyId
     */
    @JsonProperty("bk_supplier_id")
    private int bkSupplierId;

    /**
     * 主机信息
     */
    private Set<Host> hosts;
}
