/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.msg.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class NocNoticeReq extends ESBReq {

    @JsonProperty("auto_read_message")
    private String content; // 自动语音读字信息

    @JsonProperty("receiver__username")
    private String receiverUsername; //可选 短信接收者，包含用户名，用户需在蓝鲸平台注册，多个以逗号分隔，若receiver、receiver__username同时存在，以receiver为准

    @JsonProperty("user_list_information")
    private List<UserListInformation> contentBase64;  // 可选  消息内容是否base64编码，默认False，不编码，请使用base64.b64encode方法编码

    @Getter@Setter
    public static class UserListInformation {
        @JsonProperty("username")
        private String username;//        被通知人
        @JsonProperty("mobile_phone")
        private String mobilePhone;//  可选              被通知人手机号
    }
}