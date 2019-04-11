package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetJobInstanceStatusReq extends ApiReq {

    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 必填：作业实例ID
     */
    @JsonProperty("job_instance_id")
    private long id;
}
