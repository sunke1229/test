package com.tencent.bk.api.job.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 作业实例返回结果
 */
@Data
public class JobInstanceStatus {

    @JsonProperty("is_finished")
    private boolean isFinished;

    @JsonProperty("job_instance")
    private JobInstance jobInstance;

    private List<Block> blocks;

}
