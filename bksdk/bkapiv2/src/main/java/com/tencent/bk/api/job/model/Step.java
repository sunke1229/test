package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

/**
 * 步骤结构
 */
@Data
public class Step {
    /**
     * id
     */
    @JsonProperty("step_id")
    private long stepId;
    /**
     * 执行脚本id
     */
    @JsonProperty("script_id")
    private long scriptId;
    /**
     * 目标机器的执行账户名，如果为空那么沿用作业的执行账户名
     */
    private String account;
    /**
     * 脚本参数时候是敏感参数
     */
    @JsonProperty("is_param_sensitive")
    private int isParamSensitive;
    /**
     * 执行脚本的超时时间
     */
    @JsonProperty("script_timeout")
    private int scriptTimeout;
    /**
     * 执行脚本的类型:1(shell脚本)、2(bat脚本)、3(perl脚本)、4(python脚本)、5(powershell脚本)
     */
    @JsonProperty("script_type")
    private int scriptType;
    /**
     * db帐户id
     */
    @JsonProperty("db_account_id")
    private int dbAccountId;

    /**
     * 执行脚本的执行参数
     */
    @JsonProperty("script_param")
    private String scriptParam;

    /**
     * 执行脚本的内容 如果同时传了script_id和script_content，则script_id优先
     */
    @JsonProperty("script_content")
    private String scriptContent;

    /**
     * 文件传输的目标目录，如：/home/data/backup
     */
    @JsonProperty("file_target_path")
    private String fileTargetPath;

    /**
     * 源文件对象数组
     * @see FileSource
     */
    @JsonProperty("file_source")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<FileSource> fileSources;

    /**
     * IP对象数组。ip_list与custom_query_id之间任意选一或并存，ip数据会去重合并
     */
    @JsonProperty("ip_list")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<IP> ipList;

    /**
     * 配置平台上的自定义查询id列表。ip_list与custom_query_id之间任意选一或并存，ip数据会去重合并
     */
    @JsonProperty("custom_query_id")
    private Collection<String> customQueryId;

    /**
     * 步骤名称
     */
    private String name;
    /**
     * 步骤类型：1、执行脚本，2、传输文件，3、文本通知
     */
    private int type;

    /**
     * 步骤的执行次序
     */
    private int order;

    /**
     * 块次序，从1开始
     */
    @JsonProperty("block_order")
    private int blockOrder;

    /**
     * 块名称
     */
    @JsonProperty("block_name")
    private String blockName;
    /**
     * 创建者
     */
    @JsonProperty("creator")
    private String creater;
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;
    /**
     * 最后修改人
     */
    @JsonProperty("last_modify_user")
    private String lastModifyUser;
    /**
     * 最后修改时间
     */
    @JsonProperty("last_modify_time")
    private Date lastModifyTime;

    /**
     * 是否需要暂停，1.需要暂停、0.不需要暂停，默认：0。
     */
    private int pause;
}

