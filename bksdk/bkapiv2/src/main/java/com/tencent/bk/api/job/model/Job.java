package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 作业主结构
 */
@Data
public class Job {
    /**
     * id
     */
    @JsonProperty("bk_job_id")
    private long bkJobId;

    /**
     * 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 脚本创建者
     */
    @JsonProperty("creator")
    private String creater;
    /**
     * 脚本创建时间
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 脚本的最后修改人
     */
    @JsonProperty("last_modify_user")
    private String lastModifyUser;
    /**
     * 脚本的最后修改时间
     */
    @JsonProperty("last_modify_time")
    private String lastModifyTime;
    /**
     * 作业标签
     */
    @JsonProperty("tag_id")
    private String tagId;

    /**
     * 步骤数
     */
    @JsonProperty("step_num")
    private int stepNum;

    /**
     * 作业的步骤
     */
    @JsonProperty("steps")
    private List<Step> steps;
    /**
     * 全局变量
     */
    @JsonProperty("global_vars")
    private List<GlobalVar> globalVars;
}