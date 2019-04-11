package com.tencent.bk.api.paas.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 * "bk_light_app_name": "轻应用测试",
 * "app_url": "http://test.bking.com/o/gcloud/xxx/",
 * "developer": "test1;test2",
 * "introduction": "introduction",
 * "width": 1024,
 * "height": 768
 * }
 */
@Getter
@Setter
public class CreateAppReq extends ApiReq {
    /**
     * 轻应用名称
     */
    @JsonProperty("bk_light_app_name")
    private String appName;
    /**
     * 应用链接
     */
    @JsonProperty("app_url")
    private String appUrl;
    /**
     * 应用分类，可选分类： "OpsTools"（运维工具），
     * "MonitorAlarm"（监控告警），"ConfManage"（配置管理），
     * "DevTools"（开发工具），"EnterpriseIT"（企业IT），
     * "OfficeApp"（办公应用），"Other"（其它）。
     * 如果传入空参数或不是上诉分类，则使用 "Other"
     */
    @JsonProperty("app_tag")
    private String appTag;
    /**
     * 应用开发者用户名，多个以分号';'分隔
     */
    private String developer;
    /**
     * 应用的简介
     */
    private String introduction;
    /**
     * 应用在桌面打开窗口宽度
     */
    private int width;
    /**
     * 应用在桌面打开窗口高度
     */
    private int height;
}
