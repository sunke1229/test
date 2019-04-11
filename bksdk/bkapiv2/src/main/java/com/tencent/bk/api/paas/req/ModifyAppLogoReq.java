package com.tencent.bk.api.paas.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

/**
 * {
 *     "bk_app_code": "gcloud",
 *     "bk_app_secret": "xxx",
 *     "bk_token": "xxx",
 *     "bk_light_app_code": "gcloud_fdfh2kl0k",
 *     "logo": "iVBORw0KGgoA......AAABJRU5ErkJggg=="
 * }
 */
@Getter
@Setter
public class ModifyAppLogoReq extends ApiReq {
    /**
     * 	轻应用的 ID
     */
    @JsonProperty("bk_light_app_code")
    private String bkLightAppCode;
    /**
     * png 格式图片文件的 Base64 编码字符串
     */
    private String logo;
}
