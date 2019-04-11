package com.tencent.bk.api.paas.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 *     "bk_app_code": "esb_test",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "target_app_code": "bk_test;esb_test",
 * }
 */
@Getter
@Setter
public class GetAppInfoReq extends ApiReq {
    /**
     * target_app_code 表示应用 ID，多个 ID 以英文分号分隔，target_app_code 为空则表示所有应用
     */
    @JsonProperty("target_app_code")
    private String targetAppCodes;
    /**
     * fields 需要返回的字段，多个字段以英文分号分割，如果不传或传入 ""，则返回应用的 bk_app_code、bk_app_name 字段。
     * 可选的字段有：bk_app_code（应用ID），bk_app_name（应用名），introduction（应用简介），creator（创建者），developer（开发人员）
     */
    @JsonProperty("fields")
    private String fields;
}
