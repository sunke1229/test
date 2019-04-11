package com.tencent.bk.api.cc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 对象实例
 * {
 *             "bk_inst_id": 2,
 *             "bk_inst_name": "蓝鲸",
 *             "bk_obj_id": "biz",
 *             "bk_obj_name": "业务",
 *             "child": [
 *                 {
 *                     "bk_inst_id": 3,
 *                     "bk_inst_name": "作业平台",
 *                     "bk_obj_id": "set",
 *                     "bk_obj_name": "集群",
 *                     "child": [
 *                         {
 *                             "bk_inst_id": 5,
 *                             "bk_inst_name": "job",
 *                             "bk_obj_id": "module",
 *                             "bk_obj_name": "模块",
 *                             "child": []
 *                         }
 *                     ]
 *                 }
 *             ]
 *         }
 */
@Data
public class ObjectInst {
    /**
     * 实例ID
     */
    @JsonProperty("bk_inst_id")
    private int bkInstId;
    /**
     * 实例用于展示的名字
     */
    @JsonProperty("bk_inst_name")
    private String bkInstName;
    /**
     * 模型图标的名字
     */
    @JsonProperty("bk_obj_icon")
    private String bkObjIcon;
    /**
     * 模型ID biz
     */
    @JsonProperty("bk_obj_id")
    private String bkObjId;
    /**
     * 模型用于展示的名字
     */
    @JsonProperty("bk_obj_name")
    private String bkObjName;

    /**
     * 当前节点下的所有实例的集合
     */
    @JsonProperty("child")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ObjectInst> child;

}
