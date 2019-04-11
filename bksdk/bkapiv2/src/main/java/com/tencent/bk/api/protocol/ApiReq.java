package com.tencent.bk.api.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.core.sdk.protocol.IReq;
import com.tencent.bk.utils.json.JsonUtil;
import com.tencent.bk.utils.json.annotation.SkipLogField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiReq implements IReq {

    @JsonProperty("bk_app_code")
    private String appCode;
    @SkipLogField("bk_app_secret")
    @JsonProperty("bk_app_secret")
    private String appSecret;
    @JsonProperty("bk_token")
    private String bkToken;
    @JsonProperty("bk_username")
    private String userName;

    /**
     * 选填：回调URL，当任务执行完成后，JOB会调用该URL告知任务执行结果。回调协议参考callback_protocol组件文档
     * 目前仅作业执行类支持
     */
    @JsonProperty("bk_callback_url")
    private String callBackUrl;
    /**
     * 不打印出SkipLogFields指定的字段 避免日志泄露出敏感信息
     */
    @Override
    public String toString() {
        return JsonUtil.skipLogFields(this);
    }

}
