package com.tencent.bk.api.paas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateApp {

    @JsonProperty("bk_light_app_code")
    private String appCode;
}
