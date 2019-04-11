/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 子网信息
 */
@Getter
@Setter
public class PlatDto implements Serializable {

    @JsonProperty("platId")
    private int platId;

    @JsonProperty("platCompany")
    private String platCompany;

    @JsonProperty("platName")
    private String platName;

}
