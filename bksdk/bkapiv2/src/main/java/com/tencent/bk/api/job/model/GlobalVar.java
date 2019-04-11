package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * 全局变量结构
 */
@Data
public class GlobalVar {

    /**
     * 该字段仅作业平台查详情时返回才有用：
     * 全局变量类型： 1.字符串 2.IP
     */
    private int type;

    /**
     * 该字段仅作业平台查详情时返回才有用：
     * 描述
     */
    private String description;

    /**
     * 该字段仅作业平台查详情时返回才有用：
     * 全局变量名称
     */
    private String name;

    /**
     * 全局变量id，唯一标识
     */
    private long id;

    /**
     * 字符串类型的全局变量值， 当type=1时有这个参数
     */
    private String value;

    /**
     * IP对象数组，当type=2时有这个参数
     */
    @JsonProperty("ip_list")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<IP> ipList;

    /**
     * 配置平台上的动态分组id列表， 当type=2时有这个参数
     */
    @JsonProperty("custom_query_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<String> customQueryId;

    /**
     * 引用了这个IP全局变量的步骤id列表， 当type=2时有这个参数
     */
    @JsonProperty("step_ids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Long> stepIds;
}