/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.api.login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.Api;
import com.tencent.bk.api.login.model.BkUser;
import com.tencent.bk.api.login.req.GetBatchUserReq;
import com.tencent.bk.api.protocol.ApiReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 用户信息 API接口封装
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
public class BKLoginApi extends Api {

    private final static String API_GET_USER_INFO = "/api/c/compapi/v2/bk_login/get_user/";
    private final static String API_GET_ALL_USER_INFO = "/api/c/compapi/v2/bk_login/get_all_users/";
    private final static String API_GET_BATCH_USER = "/api/c/compapi/v2/bk_login/get_batch_users/";

    @Autowired
    public BKLoginApi(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

    public BKLoginApi(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        super(bkCoreProperties, language);
    }

    /**
     * 获取指定用户信息
     *
     * @param esbReq 请求
     * @return
     */
    public ApiResp<BkUser> getUserInfo(ApiReq esbReq) {
        return invokeGet(API_GET_USER_INFO, esbReq, new TypeReference<ApiResp<BkUser>>() {
        });
    }

    /**
     * 获取所有用户信息
     *
     * @param esbReq 请求
     * @return Paas平台上所有用户信息列表
     */
    public ApiResp<List<BkUser>> getAllUserInfo(ApiReq esbReq) {
        return invokeGet(API_GET_ALL_USER_INFO, esbReq, new TypeReference<ApiResp<List<BkUser>>>() {
        });
    }


    /**
     * 获取多个用户信息
     *
     * @param esbReq 请求
     * @return 用户信息
     */
    public ApiResp<Map<String, BkUser>> getBatchUser(GetBatchUserReq esbReq) {
        return invokeGet(API_GET_BATCH_USER, esbReq, new TypeReference<ApiResp<Map<String, BkUser>>>() {
        });
    }
}
