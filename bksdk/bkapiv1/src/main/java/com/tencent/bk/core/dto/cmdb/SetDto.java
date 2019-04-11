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
import java.util.List;

@Getter
@Setter
public class SetDto implements Serializable {

    @JsonProperty("SetID")
    private int setId;

    @JsonProperty("Capacity")
    private String capacity;

    @JsonProperty("Default")
    private int isDefault;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("ChnName")
    private String chnName;

    @JsonProperty("ServiceStatus")
    private String serviceStatus;

    @JsonProperty("EnviType")
    private String environmentType;

    @JsonProperty("Openstatus")
    private String openStatus;

    @JsonProperty("ParentID")
    private String parentID;

    @JsonProperty("ApplicationID")
    private int applicationID;

    @JsonProperty("LastTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastTime;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    @JsonProperty("Children")
    private List<ModuleDto> modules;

}
