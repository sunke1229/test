package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

/**
 * 此组件仅用于展示回调协议文档
 * 对作业执行类的请求传入的回调bk_callback_url地址进行回调时所传递的报文结构描述
 *
 * {
 *     "job_instance_id": 12345,
 *     "status": 2,
 *     "step_instances": [
 *         {
 *             "step_instance_id": 16271,
 *             "status": 3
 *         },
 *         {
 *             "step_instance_id": 16272,
 *             "status": 2
 *         }
 *     ]
 * }
 */
@Data
public class JobCallback {

    /**
     * 作业实例ID
     */
    @JsonProperty("job_instance_id")
    private long id;

    /**
     *  作业状态码:
     *  1.未执行;
     *  2.正在执行;
     *  3.执行成功;
     *  4.执行失败;
     *  5.跳过;
     *  6.忽略错误;
     *  7.等待用户;
     *  8.手动结束;
     *  9.状态异常;
     *  10.步骤强制终止中;
     *  11.步骤强制终止成功;
     *  12.步骤强制终止失败
     */
    private int status;

    /**
     * 步骤块中包含的各个步骤执行状态
     */
    @JsonProperty("step_instances")
    private Set<StepInstanceStatus> stepInstances;

    /**
     * 作业步骤执行状态
     * {
     *      "step_instance_id": 16271,
     *      "status": 3
     * }
     */
    @Data
    public class StepInstanceStatus {
        /**
         * 作业步骤实例ID
         */
        @JsonProperty("step_instance_id")
        private long id;
        /**
         * 作业步骤状态码:
         * 1.未执行;
         * 2.正在执行;
         * 3.执行成功;
         * 4.执行失败;
         * 5.跳过;
         * 6.忽略错误;
         * 7.等待用户;
         * 8.手动结束;
         * 9.状态异常;
         * 10.步骤强制终止中;
         * 11.步骤强制终止成功;
         * 12.步骤强制终止失败
         */
        private int status;
    }
}
