/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.api.cmsi.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendSmsReq extends ApiReq {

    @JsonProperty("content")
    private String content; // 短信内容

    @JsonProperty("receiver")
    private String receiverNum; //可选 短信接收者，包含接收者电话号码，多个以逗号分隔，若receiver、receiver__username同时存在，以receiver为准

    @JsonProperty("receiver__username")
    private String receiverUsername; //可选 短信接收者，包含用户名，用户需在蓝鲸平台注册，多个以逗号分隔，若receiver、receiver__username同时存在，以receiver为准

    @JsonProperty("is_content_base64")
    private boolean contentBase64;  // 可选  消息内容是否base64编码，默认False，不编码，请使用base64.b64encode方法编码

}