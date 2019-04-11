package com.tencent.bk.api.paas.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 * "bk_app_code": "esb_test",
 * "bk_app_secret": "xxx",
 * "bk_token": "xxx",
 * "bk_light_app_code": "gcloud_fdfh2kl0k"
 * }
 */
@Getter
@Setter
public class DeleteAppReq extends ApiReq {
    /**
     * 轻应用的 ID
     */
    @JsonProperty("bk_light_app_code")
    private String bkLightAppCode;
}
