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
public class SendMailReq extends ApiReq {

    @JsonProperty("sender")
    private String sender; //可选 发件人

    @JsonProperty("title")
    private String title; //  标题

    @JsonProperty("content")
    private String content; // 邮件内容

    @JsonProperty("receiver")
    private String receiverAddresses; //可选 邮件接收者，包含邮件完整地址，多个以逗号分隔，若receiver、receiver__username同时存在，以receiver为准

    @JsonProperty("receiver__username")
    private String receiverUsername; //可选 邮件接收者，包含用户名，用户需在蓝鲸平台注册，多个以逗号分隔，若receiver、receiver__username同时存在，以receiver为准

    @JsonProperty("cc")
    private String ccAddresses; //可选 抄送人，包含邮件完整地址，多个以逗号分隔

    @JsonProperty("cc__username")
    private String ccUserName; //可选 抄送人，包含用户名，用户需在蓝鲸平台注册，多个以逗号分隔，若cc、cc__username同时存在，以cc为准

    @JsonProperty("body_format")
    private String bodyFormat;  // 可选  邮件格式，包含'Html', 'Text'，默认为'Html'
    @JsonProperty("is_content_base64")
    private boolean contentBase64;  // 可选  邮件内容是否base64编码，默认False，不编码，请使用base64.b64encode方法编码
}