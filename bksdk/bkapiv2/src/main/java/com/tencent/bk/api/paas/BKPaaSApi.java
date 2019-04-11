/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.api.paas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.Api;
import com.tencent.bk.api.paas.model.CreateApp;
import com.tencent.bk.api.paas.model.GetAppInfo;
import com.tencent.bk.api.paas.req.*;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
public class BKPaaSApi extends Api {

    private final static String API_CREATE_APP = "/api/c/compapi/v2/bk_paas/create_app/";
    private final static String API_DELETE_APP = "/api/c/compapi/v2/bk_paas/del_app/";
    private final static String API_EDIT_APP = "/api/c/compapi/v2/bk_paas/edit_app/";
    private final static String API_GET_APP_INFO = "/api/c/compapi/v2/bk_paas/get_app_info/";
    private final static String API_MODIFY_APP_LOGO = "/api/c/compapi/v2/bk_paas/modify_app_logo/";

    @Autowired
    public BKPaaSApi(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

    public BKPaaSApi(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        super(bkCoreProperties, language);
    }

    /**
     * 创建轻应用
     *
     * @param esbReq CreateAppReq 请求
     * @return CreateApp
     */
    public ApiResp<CreateApp> createApp(CreateAppReq esbReq) {
       return invokePost(API_CREATE_APP, esbReq, new TypeReference<ApiResp<CreateApp>>() {
        });
    }

    /**
     * 下架轻应用
     *
     * @param esbReq DeleteAppReq 请求
     * @return Void
     */
    public ApiResp<Void> deleteApp(DeleteAppReq esbReq) {
        return invokePost(API_DELETE_APP, esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 编辑轻应用
     *
     * @param esbReq EditAppReq 请求
     * @return Void
     */
    public ApiResp<Void> editApp(EditAppReq esbReq) {
        return invokePost(API_EDIT_APP, esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 获取应用信息，支持批量获取
     *
     * @param esbReq GetAppInfoReq 请求
     * @return 用户信息
     */
    public ApiResp<List<GetAppInfo>> getAppInfo(GetAppInfoReq esbReq) {
        return invokePost(API_GET_APP_INFO, esbReq, new TypeReference<ApiResp<List<GetAppInfo>>>() {
        });
    }

    /**
     * 获取应用信息，支持批量获取
     *
     * @param esbReq ModifyAppLogoReq 请求
     * @return 用户信息
     */
    public ApiResp<Void> modifyAppLogo(ModifyAppLogoReq esbReq) {
        return invokePost(API_MODIFY_APP_LOGO, esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }
}
