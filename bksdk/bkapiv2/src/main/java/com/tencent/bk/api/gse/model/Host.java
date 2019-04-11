package com.tencent.bk.api.gse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {
 *  "ip": "10.0.0.1",
 *  "bk_cloud_id": 0
 * }
 */
@Data
public class Host {
    /**
     * IP地址
     */
    private String ip;
    /**
     * 云区域ID
     */
    @JsonProperty("bk_cloud_id")
    private int bkCloudId;
}
