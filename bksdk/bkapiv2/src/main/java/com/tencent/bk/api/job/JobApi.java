package com.tencent.bk.api.job;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.Api;
import com.tencent.bk.api.job.model.*;
import com.tencent.bk.api.job.req.*;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;

import java.util.List;

public class JobApi extends Api {

    public JobApi(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

    /**
     * 根据作业模板ID启动作业。支持全局变量，如果全局变量的类型为IP，参数值必须包含custom_query_id或ip_list。没有设置的参数将使用作业模版中的默认值。
     */
    public ApiResp<JobInstanceResult> executeJob(ExecuteJobReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/execute_job/", esbReq,
                new TypeReference<ApiResp<JobInstanceResult>>() {
                });
    }

    /**
     * 快速执行脚本
     */
    public ApiResp<JobInstanceResult> fastExecuteScript(FastExecuteScriptReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/fast_execute_script/", esbReq,
                new TypeReference<ApiResp<JobInstanceResult>>() {
                });
    }

    /**
     * 快速执行SQL脚本
     */
    public ApiResp<JobInstanceResult> fastExecuteSQL(FastExecuteSQLReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/fast_execute_sql/", esbReq,
                new TypeReference<ApiResp<JobInstanceResult>>() {
                });
    }

    /**
     * 快速分发文件
     */
    public ApiResp<JobInstanceResult> fastPushFile(FastPushFileReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/fast_push_file/", esbReq,
                new TypeReference<ApiResp<JobInstanceResult>>() {
                });
    }

    /**
     * 查询业务下定时作业信息
     */
    public ApiResp<List<CronJob>> getCronList(GetCronListReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/get_cron_list/", esbReq,
                new TypeReference<ApiResp<List<CronJob>>>() {
                });
    }

    /**
     * 根据作业模板ID查询作业模板详情
     */
    public ApiResp<Job> getJobDetail(GetJobDetailReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/get_job_detail/", esbReq,
                new TypeReference<ApiResp<Job>>() {
                });
    }

    /**
     * 根据作业实例ID查询作业执行日志
     */
    public ApiResp<List<StepInstanceAnalysis>> getJobInstanceLog(GetJobInstanceLogReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/get_job_instance_log/", esbReq,
                new TypeReference<ApiResp<List<StepInstanceAnalysis>>>() {
                });
    }

    /**
     * 根据作业实例ID查询作业执行状态
     */
    public ApiResp<JobInstanceStatus> getJobInstanceStatus(GetJobInstanceStatusReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/get_job_instance_status/", esbReq,
                new TypeReference<ApiResp<JobInstanceStatus>>() {
                });
    }

    /**
     * 查询作业模板
     */
    public ApiResp<List<Job>> getJobList(GetJobListReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/get_job_list/", esbReq,
                new TypeReference<ApiResp<List<Job>>>() {
                });
    }

    /**
     * 新建或保存定时作业；新建定时作业，作业状态默认为暂停；操作者必须是业务的创建人或运维
     */
    public ApiResp<CronJobId> saveCron(SaveCronReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/save_cron/", esbReq,
                new TypeReference<ApiResp<CronJobId>>() {
                });
    }

    /**
     * 更新定时作业状态，如启动或暂停；操作者必须是业务的创建人或运维
     */
    public ApiResp<CronJobId> updateCronStatus(UpdateCronStatusReq esbReq) {
        return invokePost("/api/c/compapi/v2/job/update_cron_status/", esbReq,
                new TypeReference<ApiResp<CronJobId>>() {
                });
    }
}
