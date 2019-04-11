package com.tencent.bk.api.cc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

/**
 * 自定义查询条件集合
 */
@Data
public class CustomQueryConditions {

    @JsonProperty("condition")
    private Set<CustomQueryCondition> conditionSet;
}
