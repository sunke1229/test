/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 作业详情
 */
@Getter
@Setter
public class TaskDetailDto implements Serializable {

    /**
     * id
     */
    private long id;

    /**
     * 业务id
     */
    private int appId;

    /**
     * 名称
     */
    private String name;

    /**
     * 目标机器的执行账户名
     */
    private String account;

    /**
     * ipList
     */
    private String ipList;

    /**
     * 目标机器的服务器集合id
     */
    private int serverSetId;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    /**
     * 最后修改人
     */
    private String lastModifyUser;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastModifyTime;

    /**
     * 作业的步骤
     */
    private List<StepDto> nmStepBeanList;

    /**
     * 步骤数
     */
    private int stepNum;

    /**
     * 作业标签
     */
    private String tagId;

    /**
     * 全局变量
     */
    private List<Map<String, Object>> globalVarList;

}
