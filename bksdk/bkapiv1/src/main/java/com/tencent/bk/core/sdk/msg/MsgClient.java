/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.msg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.Api;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import com.tencent.bk.core.sdk.msg.protocol.*;
import com.tencent.bk.core.sdk.protocol.ESBResp;

/**
 * 封装了发送消息的API
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
public class MsgClient extends Api {

    /**
     * 发送邮件
     */
    public ESBResp<Void> sendMail(SendMailReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/send_mail/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 发送短信
     */
    public ESBResp<Void> sendSms(SendSmsReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/send_sms/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 公共语音通知
     */
    public ESBResp<Void> nocNotice(NocNoticeReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/noc_notice/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    public MsgClient(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }
}
