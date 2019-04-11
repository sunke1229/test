package com.tencent.bk.api.paas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Setter@Getter@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAppInfo {
    /**
     * 	轻应用的 ID
     */
    @JsonProperty("bk_app_code")
    private String appCode;
    /**
     * 轻应用名称
     */
    @JsonProperty("bk_app_name")
    private String appName;
    /**
     * 应用创建者
     */
    private String creator;
    /**
     * 应用开发者用户名，多个以分号';'分隔
     */
    private String developer;
    /**
     * 应用的简介
     */
    private String introduction;
}
