package com.tencent.bk.api.cmsi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.Api;
import com.tencent.bk.api.cmsi.req.*;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;

public class CMSIApi extends Api {

    public CMSIApi(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

    /**
     * 发送邮件
     */
    public ApiResp<Void> sendMail(SendMailReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/send_mail/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 发送短信
     */
    public ApiResp<Void> sendSms(SendSmsReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/send_sms/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 公共语音通知
     */
    public ApiResp<Void> nocNotice(NocNoticeReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/noc_notice/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 发送企业微信
     */
    public ApiResp<Void> sendQyWeixin(SendQyWxReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/send_qy_weixin/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 发送微信消息，支持微信公众号消息，及微信企业号消息
     */
    public ApiResp<Void> sendWeixin(SendWxReq esbReq) {
        return invokePost("/api/c/compapi/cmsi/send_weixin/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }
}
