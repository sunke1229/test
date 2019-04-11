/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.core.sdk.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.utils.json.JsonUtil;
import com.tencent.bk.utils.json.annotation.SkipLogField;
import lombok.Getter;
import lombok.Setter;

/**
 * ESB请求基础协议，后续其他接口根据此继承在子类中增加对应的参数
 */
@Setter
@Getter
public class ESBReq implements IReq{

    @JsonProperty("app_code")
    private String appCode;

    @SkipLogField("app_secret")
    @JsonProperty("app_secret")
    private String appSecret;

    @JsonProperty("username")
    private String userName;
    @JsonProperty("bk_token")
    private String bkToken;

    /**
     * 不打印出SkipLogFields指定的字段 避免日志泄露出敏感信息
     */
    @Override
    public String toString() {
        return JsonUtil.skipLogFields(this);
    }

}
