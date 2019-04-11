package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * IP结构
 */
@Data
public class IP {
    
    @JsonProperty("bk_cloud_id")
    private int bkCloudId;

    private String ip;

}
