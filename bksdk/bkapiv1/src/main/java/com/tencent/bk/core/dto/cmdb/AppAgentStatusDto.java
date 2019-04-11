/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Getter
@Setter
public class AppAgentStatusDto implements Serializable {
    private List<AgentDto> agentNorList; //正常Agent列表
    private List<AgentDto> agentAbnorList; //状态异常Agent列表
    private int agentAbnorCnt;//异常Agent的数量
    private int agentNorCnt; //正常Agent的数量

    @Getter
    @Setter
    public static class AgentDto implements Serializable {
        @JsonProperty("Ip")
        private String ip;
        @JsonProperty("PlatId")
        private int platId;
        @JsonProperty("CompanyId")
        private int companyId;
    }
}
