/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.core.sdk.paas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.dto.login.BkUserDto;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.Api;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import com.tencent.bk.core.sdk.paas.protocol.GetBatchUserReq;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import com.tencent.bk.core.sdk.protocol.ESBResp;

import java.util.List;
import java.util.Map;

/**
 * PAAS API接口封装
 * 注意所有接口都有bkToken和userName参数，两个参数用途需要规范
 * bkToken用于web系统引发的接口调用是由当前登录用户触发的行为，一概要求传递bkToken
 * userName用于后台任务执行由系统触发，传递userName，此时没有用户登录态也就没有bkToken
 * 如果bkToken不为空，则优先以bkToken为准
 * <p>
 * 构建请求参数请用
 *
 * @see DefaultSDKClient makeBaseReqByWeb  （当前登录用户触发的行为）
 * @see DefaultSDKClient makeBaseReq    （由后台任务调用的行为）
 */
public class PAASClient extends Api {

    private final static String API_GET_USER_INFO = "/api/c/compapi/bk_login/get_user/";
    private final static String API_GET_ALL_USER_INFO = "/api/c/compapi/bk_login/get_all_user/";
    private final static String API_GET_BATCH_USER = "/api/c/compapi/bk_login/get_batch_user/";

    public PAASClient(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

    /**
     * 获取指定用户信息
     *
     * @param esbReq 请求
     * @return
     */
    public ESBResp<BkUserDto> getUserInfo(ESBReq esbReq) {
        return invokeGet(API_GET_USER_INFO, esbReq,
                new TypeReference<ESBResp<BkUserDto>>() {
                });
    }

    /**
     * 获取所有用户信息
     *
     * @param esbReq 请求
     * @return Paas平台上所有用户信息列表
     */
    public ESBResp<List<BkUserDto>> getAllUserInfo(ESBReq esbReq) {
        return invokeGet(API_GET_ALL_USER_INFO, esbReq,
                new TypeReference<ESBResp<List<BkUserDto>>>() {
                });
    }


    /**
     * 获取多个用户信息
     *
     * @param esbReq 请求
     * @return 用户信息
     */
    public ESBResp<Map<String, BkUserDto>> getBatchUser(GetBatchUserReq esbReq) {
        return invokeGet(API_GET_BATCH_USER, esbReq,
                new TypeReference<ESBResp<Map<String, BkUserDto>>>() {
                });
    }

    /**
     * 取登录PaaS的地址，并拼接返回app的url地址，需要传入访问当前app的contextPath
     */
    public String getLoginUrl() {
        return bkCoreProperties.getPaasHost() + "/login/?app_id=" + bkCoreProperties.getAppCode() + "&c_url=" + urlEncode(bkCoreProperties.getAppHost());
    }
}
