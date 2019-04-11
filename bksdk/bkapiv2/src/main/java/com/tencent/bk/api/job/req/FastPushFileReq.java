package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.job.model.FileSource;
import com.tencent.bk.api.job.model.IP;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
public class FastPushFileReq extends ApiReq {

    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 必填： 执行帐号名/别名
     */
    private String account;

    @JsonProperty("file_target_path")
    private String fileTargetPath;

    @JsonProperty("file_source")
    private Collection<FileSource> fileSources;

    /**
     * IP对象数组。ip_list与custom_query_id之间任意选一或并存，ip数据会去重合并
     */
    @JsonProperty("ip_list")
    private Collection<IP> ipDtoList;

    /**
     * 配置平台上的自定义查询id列表。ip_list与custom_query_id之间任意选一或并存，ip数据会去重合并
     */
    @JsonProperty("custom_query_id")
    private Collection<String> customQueryId;
}
