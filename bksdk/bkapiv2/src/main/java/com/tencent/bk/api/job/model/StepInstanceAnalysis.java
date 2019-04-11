package com.tencent.bk.api.job.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 当前步骤结果分析
 *
 * @author irwinsun
 * @version 1.0
 * @date 2018/3/12
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class StepInstanceAnalysis {
    /**
     * 作业是否结束了
     */
    @JsonProperty("is_finished")
    private boolean isFinished;
    /**
     * 作业步骤实例ID
     */
    @JsonProperty("step_instance_id")
    private long id;
    /**
     * 作业实例名称
     */
    private String name;
    /**
     * 作业步骤状态码:
     * 1.未执行;
     * 2.正在执行;
     * 3.执行成功;
     * 4.执行失败;
     * 5.跳过;
     * 6.忽略错误;
     * 7.等待用户;
     * 8.手动结束;
     * 9.状态异常;
     * 10.步骤强制终止中;
     * 11.步骤强制终止成功;
     * 12.步骤强制终止失败
     */
    private int status;
    /**
     * 当前步骤下所有ip的日志 按tag分类或 ip的执行状态(ip_status)归类存放
     */
    @JsonProperty("step_results")
    private List<StepInstanceResult> stepResults;
}
