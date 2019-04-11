package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * IP日志内容
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IPLog extends IP {
    /**
     * 开始执行时间，YYYY-MM-DD HH:mm:ss
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 执行结束时间，YYYY-MM-DD HH:mm:ss格式
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 总耗时,秒
     */
    @JsonProperty("total_time")
    private float totalTime;
    /**
     * 步骤重试次数
     */
    @JsonProperty("retry_count")
    private int retryCount;
    /**
     * 作业执行中出错码
     */
    @JsonProperty("error_code")
    private int errCode;
    /**
     * shell脚本退出码; 0正常; 非0异常
     */
    @JsonProperty("exit_code")
    private int exitCode;
    /**
     * 作业脚本输出的日志内容
     */
    @JsonProperty("log_content")
    private String logContent;

}
