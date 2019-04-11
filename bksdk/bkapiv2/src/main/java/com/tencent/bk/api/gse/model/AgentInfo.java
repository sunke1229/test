package com.tencent.bk.api.gse.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {
 *      "ip": "10.0.0.1",
 *      "version": "V0.01R060D38",
 *      "bk_cloud_id": 0,
 *      "parent_ip": "10.0.0.2",
 *      "parent_port": 50000
 * }
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AgentInfo extends Host {

    /**
     * agent版本号
     */
    private String version;

    /**
     * 	agent的上级节点ip
     */
    @JsonProperty("parent_ip")
    private String parentIp;

    /**
     * agent的上级节点端口
     */
    @JsonProperty("parent_port")
    private String parentPort;

}
