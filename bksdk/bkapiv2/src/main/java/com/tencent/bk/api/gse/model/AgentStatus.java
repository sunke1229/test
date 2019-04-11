package com.tencent.bk.api.gse.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {
 * "ip": "10.0.0.1",
 * "bk_cloud_id": 0,
 * "bk_agent_alive": 1
 * }
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AgentStatus extends Host {

    /**
     * agent在线状态，0为不在线，1为在线
     */
    @JsonProperty("bk_agent_alive")
    private int alive;
}
