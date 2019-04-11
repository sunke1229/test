package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JobInstance {
    /**
     * 作业实例id
     */
    @JsonProperty("job_instance_id")
    private long id;
    /**
     * task id
     */
    @JsonProperty("bk_job_id")
    private long bkJobId;
    /**
     * 业务id
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 状态： 1.未执行、2.正在执行、3.执行完成且成功、4.执行失败
     */
    @JsonProperty("status")
    private int status;
    /**
     * 作业实例名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 执行人
     */
    @JsonProperty("operator")
    private String operator;
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
     * 开始时间
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 结束时间
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 总耗时，单位：秒
     */
    @JsonProperty("total_time")
    private Float totalTime;

    /**
     * 启动方式： 1.页面执行、2.API调用、3.定时执行
     */
    @JsonProperty("start_way")
    private int startWay;
    /**
     * 操作列表
     */
    @JsonProperty("current_step_instance_id")
    private long currentStepId;
}