/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * KeyValue
 */
@Getter
@Setter
public class PropertyValueDto implements Serializable {

    @JsonProperty("Property")
    private String property;

    @JsonProperty("value")
    private String value;
}
