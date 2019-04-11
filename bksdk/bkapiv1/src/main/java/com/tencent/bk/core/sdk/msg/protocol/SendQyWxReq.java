/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.msg.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendQyWxReq extends ESBReq {
    /**
     * 通知 内容
     */
    @JsonProperty("content")
    private String content;
    /**
     * 微信接收者，包含企业微信用户ID，多个以逗号分隔
     */
    @JsonProperty("receiver")
    private String receiverWxUserIds;

}