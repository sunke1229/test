package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.job.model.GlobalVar;
import com.tencent.bk.api.job.model.Step;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExecuteJobReq extends ApiReq {

    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;

    /**
     * 必填：要执行的作业模板ID
     */
    @JsonProperty("bk_job_id")
    private int bkJobId;

    /**
     * 选填：指定要执行或自定义参数的步骤数组，要执行全部步骤可不传此参数，见下面steps结构定义
     */
    private List<Step> Steps;

    /**
     * 选填：全局变量信息，作业包含的全局变量和类型，可以通过接口“查询作业模板详情” (get_job_detail)获取
     */
    @JsonProperty("global_vars")
    private List<GlobalVar> globalVars;
}
