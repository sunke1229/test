package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * 源文件结构
 */
@Data
public class FileSource {

    /**
     * 源文件的绝对路径数组，支持多个文件
     */
    private List<String> files;
    /**
     * 执行帐号名/别名
     */
    private String account;

    /**
     * 配置平台上的自定义查询ip列表。
     * ip_list与custom_query_id之间任意选一或并存，ip数据会去重合并
     */
    @JsonProperty("custom_query_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<String> customQueryId;

    /**
     * IP对象数组。ip_list与custom_query_id之间任意选一或并存，ip数据会去重合并
     */
    @JsonProperty("ip_list")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<IP> ipList;
}
