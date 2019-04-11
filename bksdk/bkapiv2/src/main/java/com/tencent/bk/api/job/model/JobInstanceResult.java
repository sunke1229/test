package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 提交作业后立即返回作业实例对象
 */
@Data
public class JobInstanceResult {

    @JsonProperty("job_instance_id")
    private long id;

    @JsonProperty("job_instance_name")
    private String name;

}
