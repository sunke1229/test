/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.msg.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 * "app_code": "esb_test",
 * "app_secret": "xxx",
 * "bk_token": "xxx",
 * "receiver": "xxx",
 * "data": {
 * "heading": "蓝鲸平台通知",
 * "message": "This 是 a test.",
 * "date": "2017-02-22 15:36",
 * "remark": "zhen 是一个测试！"
 * }
 * }
 */
@Setter
@Getter
public class SendWxReq extends ESBReq {
    /**
     * 通知 内容
     */
    @JsonProperty("content")
    private String content;
    /**
     * 微信接收者，包含绑定在指定公众号上的微信用户的 openid 或 企业号上的微信用户的用户ID，多个以逗号分隔
     */
    @JsonProperty("receiver")
    private String receiverWxUserIds;

    /**
     * 微信接收者，包含用户名，用户需在蓝鲸平台注册，多个以逗号分隔，若receiver、receiver__username同时存在，以receiver为准
     */
    @JsonProperty("receiver__username")
    private String receiverUsername;

    /**
     * 消息内容
     */
    private Data Data;

    /**
     * {
     * *         "heading": "蓝鲸平台通知",
     * *         "message": "This 是 a test.",
     * *         "date": "2017-02-22 15:36",
     * *         "remark": "zhen 是一个测试！"
     * *     }
     */
    @Getter
    @Setter
    public static class Data {
        /**
         * 通知头部文字
         */
        private String heading;
        /**
         * 通知文字
         */
        private String message;
        /**
         * 通知发送时间，默认为当前时间 "YYYY-mm-dd HH:MM"
         */
        private String date;
        /**
         * 通知尾部文字
         */
        private String remark;
        /**
         * 通知文字message是否base64编码，默认False，不编码，若编码请使用base64.b64encode方法
         */
        @JsonProperty("is_message_base64")
        private boolean isBase64;
    }
}