package com.tencent.bk.api.job.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 当前步骤下所有ip的日志
 */
@Data
public class StepInstanceResult {
    /**
     * 主机任务状态码:
     * 1.Agent异常; 3.上次已成功; 5.等待执行; 7.正在执行; 9.执行成功;
     * 11.任务失败; 12.任务下发失败; 13.任务超时; 15.任务日志错误; 101.脚本执行失败;
     * 102.脚本执行超时; 103.脚本执行被终止; 104.脚本返回码非零; 202.文件传输失败;
     * 203.源文件不存在; 310.Agent异常; 311.用户名不存在; 320.文件获取失败;
     * 321.文件超出限制; 329.文件传输错误; 399.任务执行出错
     */
    @JsonProperty("ip_status")
    private int ipStatus;
    /**
     * 脚本用job_success/job_fail 函数返回的标签内容
     */
    private String tag;
    /**
     * ip 日志内容
     */
    @JsonProperty("ip_logs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IPLog> ipLogs;
}
