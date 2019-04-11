/*
 * Copyright (c) 2018. Tencent BlueKing
 */

package com.tencent.bk.api.gse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.Api;
import com.tencent.bk.api.gse.model.AgentInfo;
import com.tencent.bk.api.gse.model.AgentStatus;
import com.tencent.bk.api.gse.req.GetAgentInfoReq;
import com.tencent.bk.api.gse.req.GetAgentStatusReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 蓝鲸管控平台 API
 * 注意所有接口都有bkToken和userName参数，两个参数用途需要规范
 * bkToken用于web系统引发的接口调用是由当前登录用户触发的行为，一概要求传递bkToken
 * userName用于后台任务执行由系统触发，传递userName，此时没有用户登录态也就没有bkToken
 * 如果bkToken不为空，则优先以bkToken为准
 * <p>
 * 所有结果请根据Resp中的code来决定是否成功
 * <p>
 * 构建请求参数请用
 *
 * @see DefaultSDKClient makeBaseReqByWeb  （当前登录用户触发的行为）
 * @see DefaultSDKClient makeBaseReq    （由后台任务调用的行为）
 */
public class GseApi extends Api {

    /**
     * 查询agent心跳详细信息。数据非实时，延时1分钟内。
     *
     * @return Map 的 key 格式为：bk_cloud_id:ip
     */
    public ApiResp<Map<String, AgentInfo>> getAgentInfo(GetAgentInfoReq esbReq) {
        return invokePost("/api/c/compapi/v2/gse/get_agent_info/", esbReq,
                new TypeReference<ApiResp<Map<String, AgentInfo>>>() {
                });
    }

    /**
     * 查询agent实时在线状态
     *
     * @return Map 的 key 格式为：bk_cloud_id:ip
     */
    public ApiResp<Map<String, AgentStatus>> getAgentStatus(GetAgentStatusReq esbReq) {
        return invokePost("/api/c/compapi/v2/gse/get_agent_status/", esbReq,
                new TypeReference<ApiResp<Map<String, AgentStatus>>>() {
                });
    }

    @Autowired
    public GseApi(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

    public GseApi(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        super(bkCoreProperties, language);
    }
}
