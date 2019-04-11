/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.job.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class FastPushFileReq extends ESBReq {

    @JsonProperty("app_id")
    private int applicationId;

    /**
     * 执行账户账户名
     */
    private String account;

    /**
     * 目标路径
     */
    @JsonProperty("file_target_path")
    private String fileTargetPath;
    /**
     * 源文件信息，整个参数替换，不支持内部某个变量替换。格式参考下面说明
     */
    @JsonProperty("file_source")
    private List<FileSource> fileSource;

    /**
     * 目标机器，包含以下内容：
     * [{
     * "ip": "10.1.1.1",
     * "source": 1
     * }]
     */
    @JsonProperty("ip_list")
    private List<Map<String, Object>> ipList;

    /**
     * 可选 目标机器所属业务，全业务需要
     */
    @JsonProperty("target_app_id")
    private int targetAppId;

    /**
     * 可选 目标机器分组ID；server_set_id和ip_list至少一个必须存在，如果同时存在，则以server_set_id为准
     */
    @JsonProperty("server_set_id")
    private int serverSetId;

    @Getter
    @Setter
    public static class FileSource {
        /**
         * 可选 为源机器所属业务，全业务需要
         */
        @JsonProperty("source_app_id")
        private int srcAppId;
        /**
         * 可选 源文件服务器分区ID；server_set_id和ip_list至少一个必须存在，如果同时存在，则以server_set_id为准
         */
        @JsonProperty("server_set_id")
        private int serverSetId;
        /**
         * 源文件路径
         */
        private String file;
        /**
         * 执行账户账户名
         */
        private String account;
    }
}