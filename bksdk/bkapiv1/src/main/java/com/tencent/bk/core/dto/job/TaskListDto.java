/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 作业模块列表数据对象（只有列表部分字段，不包含全部字段，所以单独叫ListTaskDto，
 * 完整的字段见TaskDetailDto
 *
 * @see TaskDetailDto
 */
@Getter
@Setter
public class TaskListDto implements Serializable {

    /**
     * id
     */
    private int id;

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
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 最后修改人
     */
    private String lastModifyUser;

    /**
     * 最后修改时间
     */
    private Timestamp lastModifyTime;

    /**
     * 作业标签
     */
    private String tagId;


}
