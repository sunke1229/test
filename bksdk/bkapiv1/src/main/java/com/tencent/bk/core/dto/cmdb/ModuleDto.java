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

@Getter
@Setter
public class ModuleDto implements Serializable {

    @JsonProperty("ModuleID")
    private int moduleID;

    @JsonProperty("SetID")
    private int setId;

    @JsonProperty("ModuleName")
    private String moduleName;

    @JsonProperty("HostNum")
    private int hostNum;

    @JsonProperty("Default")
    private int isDefault;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Operator")
    private String operator;

    @JsonProperty("BakOperator")
    private String bakOperator;

    @JsonProperty("ApplicationID")
    private int applicationID;

    @JsonProperty("LastTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastTime;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
}
