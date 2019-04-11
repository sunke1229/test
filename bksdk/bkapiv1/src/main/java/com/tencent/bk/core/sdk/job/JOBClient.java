/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.core.sdk.job;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.dto.job.*;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.Api;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import com.tencent.bk.core.sdk.job.protocol.*;
import com.tencent.bk.core.sdk.protocol.ESBResp;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 作业平台API
 * 注意所有接口都有bkToken和userName参数，两个参数用途需要规范
 * bkToken用于web系统引发的接口调用是由当前登录用户触发的行为，一概要求传递bkToken
 * userName用于后台任务执行由系统触发，传递userName，此时没有用户登录态也就没有bkToken
 * 如果bkToken不为空，则优先以bkToken为准
 * <p>
 * 构建请求参数请用
 *
 * @see DefaultSDKClient makeBaseReqByWeb  （当前登录用户触发的行为）
 * @see DefaultSDKClient makeBaseReq    （由后台任务调用的行为）
 * <p>
 * 所有结果请根据Resp中的code来决定是否成功
 */
public class JOBClient extends Api {


    /**
     * 更新定时作业状态 ，如启动或暂停；操作者必须是业务的创建人或运维
     */
    public ESBResp<Integer> changeCronTaskStatus(ChangeCronTaskStatusReq esbReq) {
        ESBResp<Map<String, Integer>> mapESBResp = invokePost("/api/c/compapi/job/change_cron_status/", esbReq,
                new TypeReference<ESBResp<Map<String, Integer>>>() {
                });
        ESBResp<Integer> resp = new ESBResp<>();
        resp.setResult(mapESBResp.getResult());
        resp.setMessage(mapESBResp.getMessage());
        resp.setCode(mapESBResp.getCode());
        if (mapESBResp.getData() != null) {
            Iterator<Integer> iterator = mapESBResp.getData().values().iterator();
            if (iterator.hasNext()) {
                resp.setData(iterator.next());
            }
        }
        return resp;
    }

    /**
     * 根据作业模板ID启动作业
     */
    public ESBResp<Map<String, Object>> executeTask(ExecuteTaskReq esbReq) {
        return invokePost("/api/c/compapi/job/execute_task/", esbReq,
                new TypeReference<ESBResp<Map<String, Object>>>() {
                });
    }

    /**
     * 启动作业Ext(带全局变量启动)
     * <p>
     * 如果全局变量的类型为IP，参数值必须包含groupIds或ipList。没有设置的参数将使用作业模版中的默认值
     */
    public ESBResp<Map<String, Object>> executeTaskExt(ExecuteTaskExtReq esbReq) {
        return invokePost("/api/c/compapi/job/execute_task_ext/", esbReq,
                new TypeReference<ESBResp<Map<String, Object>>>() {
                });
    }

    /**
     * 快速执行脚本
     */
    public ESBResp<Map<String, Object>> fastExecuteScript(FastExecuteScriptReq esbReq) {
        return invokePost("/api/c/compapi/job/fast_execute_script/", esbReq,
                new TypeReference<ESBResp<Map<String, Object>>>() {
                });
    }

    /**
     * 快速分发文件
     */
    public ESBResp<Map<String, Object>> fastPushFile(FastPushFileReq esbReq) {
        return invokePost("/api/c/compapi/job/fast_push_file/", esbReq,
                new TypeReference<ESBResp<Map<String, Object>>>() {
                });
    }

    /**
     * 查询Agent状态
     */
    public ESBResp<CronTaskDto> getAgentStatus(GetAgentStatusReq esbReq) {
        return invokePost("/api/c/compapi/job/get_agent_status/", esbReq,
                new TypeReference<ESBResp<CronTaskDto>>() {
                });
    }

    /**
     * 查询业务下定时作业信息
     */
    public ESBResp<CronTaskDto> queryCron(QueryCronTaskReq esbReq) {
        return invokePost("/api/c/compapi/job/get_cron/", esbReq,
                new TypeReference<ESBResp<CronTaskDto>>() {
                });
    }

    /**
     * 查询作业模板列表
     */
    public ESBResp<List<TaskListDto>> getTaskList(GetTaskListReq esbReq) {
        return invokePost("/api/c/compapi/job/get_task/", esbReq,
                new TypeReference<ESBResp<List<TaskListDto>>>() {
                });
    }

    /**
     * 查询作业模板详情
     */
    public ESBResp<TaskDetailDto> getTaskDetail(GetTaskDetailReq esbReq) {
        return invokePost("/api/c/compapi/job/get_task_detail/", esbReq,
                new TypeReference<ESBResp<TaskDetailDto>>() {
                });
    }

    /**
     * 根据作业实例ID查询作业执行日志
     */
    public ESBResp<List<TaskIpLogDto>> getTaskIpLog(GetTaskIpLogReq esbReq) {
        return invokePost("/api/c/compapi/job/get_task_ip_log/", esbReq,
                new TypeReference<ESBResp<List<TaskIpLogDto>>>() {
                });
    }

    /**
     * 根据作业实例 ID 查询作业执行状态
     */
    public ESBResp<TaskResultDto> getTaskResult(GetTaskResultReq esbReq) {
        return invokePost("/api/c/compapi/job/get_task_result/", esbReq,
                new TypeReference<ESBResp<TaskResultDto>>() {
                });
    }

    /**
     * 新建或保存定时作业 ；新建定时作业，作业状态默认为暂停；操作者必须是业务的创建人或运维
     */
    public ESBResp<Integer> saveCronTask(SaveCronTaskReq esbReq) {
        ESBResp<Map<String, Integer>> mapESBResp = invokePost("/api/c/compapi/job/save_cron/", esbReq,
                new TypeReference<ESBResp<Map<String, Integer>>>() {
                });
        ESBResp<Integer> resp = new ESBResp<>();
        resp.setResult(mapESBResp.getResult());
        resp.setMessage(mapESBResp.getMessage());
        resp.setCode(mapESBResp.getCode());
        if (mapESBResp.getData() != null) {
            Iterator<Integer> iterator = mapESBResp.getData().values().iterator();
            if (iterator.hasNext()) {
                resp.setData(iterator.next());
            }
        }
        return resp;
    }

    public JOBClient(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }
}
