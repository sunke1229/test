/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FileSourceDto implements Serializable {
    /**
     * 源文件路径，如：/tmp/t.txt
     */
    private String file;
    /**
     * 源文件服务器地址，格式为：子网ID:IP，多个之间逗号分割
     */
    private String ipList;
    /**
     * 源文件机器执行账户账户名
     */
    private String account;
}