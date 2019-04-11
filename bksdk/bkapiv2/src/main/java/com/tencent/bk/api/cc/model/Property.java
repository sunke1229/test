package com.tencent.bk.api.cc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {
 * "bk_property_id": "bk_host_id",
 * "bk_property_name": "主机ID",
 * "bk_property_value": "10000"
 * }
 */
@Data
public class Property {
    /**
     * 属性id
     */
    @JsonProperty("bk_property_id")
    private String propertyId;
    /**
     * 属性名称
     */
    @JsonProperty("bk_property_name")
    private String propertyName;
    /**
     * 属性值
     */
    @JsonProperty("bk_property_value")
    private Object propertyValue;

}
