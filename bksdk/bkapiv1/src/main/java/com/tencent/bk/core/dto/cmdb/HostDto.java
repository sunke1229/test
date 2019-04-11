/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 完整的业务下主机服务器信息
 */
@Getter
@Setter
public class HostDto implements Serializable {

    @JsonProperty("Source")
    private int source;

    @JsonProperty("BakOperator")
    private String bakOperator;

    @JsonProperty("SetName")
    private String setName;

    @JsonProperty("ModuleName")
    private String moduleName;

    @JsonProperty("ApplicationName")
    private String applicationName;

    @JsonProperty("Operator")
    private String operator;

    @JsonProperty("SetID")
    private int setId;

    @JsonProperty("ApplicationID")
    private int applicationId;

    @JsonProperty("ModuleID")
    private int moduleId;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("HardMemo")
    private String hardMemo;

    @JsonProperty("HostID")
    private int hostID;

    @JsonProperty("AssetID")
    private String assetID;

    @JsonProperty("InnerIP")
    private String ip;

    @JsonProperty("Region")
    private String region;

    @JsonProperty("HostName")
    private String hostName;

    @JsonProperty("IdcName")
    private String idcName;

    @JsonProperty("OSName")
    private String os;

    @JsonProperty("DeviceClass")
    private String deviceClass;

    @JsonProperty("OuterIP")
    private String outerIp;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
}
