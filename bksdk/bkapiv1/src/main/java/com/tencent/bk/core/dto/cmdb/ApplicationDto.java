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
 * 完整的业务描述对象
 */
@Getter
@Setter
public class ApplicationDto implements Serializable {

    /**
     * 对应的CC业务ID
     */
    @JsonProperty("ApplicationID")
    private int applicationId;

    /**
     * 业务名称
     */
    @JsonProperty("ApplicationName")
    private String applicationName;

    /**
     * 开发商所有者
     */
    @JsonProperty("Owner")
    private String owner;
    /**
     * 所属部门
     */
    @JsonProperty("DeptName")
    private String deptName;

    /**
     * 业务类型
     */
    @JsonProperty("Type")
    private int type;

    /**
     * 描述
     */
    @JsonProperty("Description")
    private String description;

    /**
     * BusinessDeptName
     */
    @JsonProperty("BusinessDeptName")
    private String businessDeptName;

    /**
     * 创建者
     */
    @JsonProperty("Creator")
    private String creator;

    @JsonProperty("Default")
    private int isDefault;

    /**
     * 树级数：2级，3级
     */
    @JsonProperty("Level")
    private int level = 2;

    @JsonProperty("Display")
    private int display;

    /**
     * 来源
     */
    @JsonProperty("Source")
    private String source;

    /**
     * 组名称
     */
    @JsonProperty("GroupName")
    private String groupName;

    /**
     * 业务运维
     */
    @JsonProperty("Maintainers")
    private String maintainers;

    /**
     * 开发商id
     */
    @JsonProperty("CompanyID")
    private int companyId;

    /**
     * 产品经理
     */
    @JsonProperty("ProductPm")
    private String productPm;

    /**
     * 生命周期，公测
     */
    @JsonProperty("LifeCycle")
    private String lifeCycle;

    /**
     * 更新时间
     */
    @JsonProperty("LastTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastTime;

    /**
     * 创建时间
     */
    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    /**
     *
     */
    @JsonProperty("ProjectID")
    private int projectID;
}