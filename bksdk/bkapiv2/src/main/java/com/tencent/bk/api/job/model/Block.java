package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 步骤块结构，按步骤类型归类的一种结构，见作业平台新建作业页面
 */
@Data
public class Block {

    /**
     * 步骤块类型：1.脚本步骤; 2.文件步骤; 4.SQL步骤
     */
    @JsonProperty("type")
    private int type;
    /**
     * 步骤块顺序
     */
    @JsonProperty("block_order")
    private int blockOrd;
    /**
     * 步骤块名称
     */
    @JsonProperty("block_name")
    private String blockName;
    /**
     * 步骤块中包含的各个步骤对象
     */
    @JsonProperty("step_instances")
    private List<StepInstance> stepInstances;

}