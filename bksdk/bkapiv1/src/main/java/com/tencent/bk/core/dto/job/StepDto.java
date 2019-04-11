/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class StepDto implements Serializable {
    /**
     * 想要执行的步骤ID
     */
    private int stepId;
    /**
     * 脚本ID 可选
     */
    private int scriptId;
    /**
     * 脚本超时时间 可选
     */
    private int scriptTimeout;
    /**
     * 脚本参数 可选
     */
    private String scriptParam;
    /**
     * IP列表格式：子网ID:IP，多个之间逗号，分割，例如：1:10.1.1.1,1:10.1.1.2
     */
    private String ipList;
    /**
     * 执行账户账户名 可选
     */
    private String account;
    /**
     * 目标路径 可选
     */
    private String fileTargetPath;
    /**
     * 可选
     * 源文件信息，整个参数替换，不支持内部某个变量替换。格式参考下面说明
     */
    private List<FileSourceDto> fileSource;

}