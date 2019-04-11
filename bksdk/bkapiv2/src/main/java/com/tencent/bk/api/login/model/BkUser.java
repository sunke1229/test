package com.tencent.bk.api.login.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BkUser implements Serializable {

    @JsonProperty("bk_username")
    private String username;
    @JsonProperty("bk_role")
    private int role;
    private String qq;
    private String phone;
    private String email;
    private String chname;
    @JsonProperty("wx_userid")
    private String wxUserId;
    @JsonProperty("time_zone")
    private String timeZone;
    private String language;
}
