package com.tencent.bk.api.cc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CustomQueryCondition {
    /**
     * 对象名,可以为biz,set,module,host,object
     */
    @JsonProperty("bk_obj_id")
    private String bkObjId;
    /**
     * 查询输出字段
     */
    private Set<String> fields;
    /**
     * 条件
     */
    private List<Condition> condition;
}
