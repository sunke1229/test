package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StepInstance {
    /**
     * id
     */
    @JsonProperty("step_instance_id")
    private long id;
    /**
     * 执行步骤id
     */
    @JsonProperty("step_id")
    private long stepId;
    /**
     * 名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 步骤类型：1、执行脚本，2、传输文件，3、文本通知, 4、SQL执行
     */
    @JsonProperty("type")
    private int type;

    /**
     * 步骤执行的次序
     */
    @JsonProperty("order")
    private int ord;
    /**
     * 执行人
     */
    @JsonProperty("operator")
    private String operator;
    /**
     * 状态： 1.未执行、2.正在执行、3.执行完成且成功、4.执行失败
     */
    @JsonProperty("status")
    private int status;
    /**
     * 重试次数
     */
    @JsonProperty("retry_count")
    private int retryCount;
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
     * 创建时间
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 是否需要暂停，1.需要暂停、0.不需要暂停，默认：0。
     */
    @JsonProperty("pause")
    private int isPause;
    /**
     * 操作列表
     */
    @JsonProperty("operation_list")
    private List<Operation> operationList;
}