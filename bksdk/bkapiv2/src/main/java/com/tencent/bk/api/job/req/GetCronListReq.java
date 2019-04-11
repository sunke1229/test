package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetCronListReq extends ApiReq {

    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 定时任务ID 如果存在则忽略其他筛选条件 只查询这个指定的作业信息
     */
    @JsonProperty("cron_id")
    private long cronId ;
    /**
     * 定时作业的状态： 1.已启动 2.已暂停、3.已完成
     */
    @JsonProperty("cron_status")
    private int cronStatus;
    /**
     * 定时作业名称
     */
    @JsonProperty("cron_name")
    private String cronName;
    /**
     * 定时作业创建人帐号
     */
    private String creator;
    /**
     * 创建起始时间，YYYY-MM-DD格式
     */
    @JsonProperty("create_time_start")
    private String createTimeStart;
    /**
     * 创建结束时间，YYYY-MM-DD格式
     */
    @JsonProperty("create_time_end")
    private String createTimeEnd;
    /**
     * 作业修改人帐号
     */
    @JsonProperty("last_modify_user")
    private String lastModifyUser;
    /**
     * 最后修改开始时间，YYYY-MM-DD格式
     */
    @JsonProperty("last_modify_time_start")
    private String lastModifyTimeStart;
    /**
     * 最后修改结束时间，YYYY-MM-DD格式
     */
    @JsonProperty("last_modify_time_end")
    private String lastModifyTimeEnd;
    /**
     * 默认0表示从第1条记录开始返回
     */
    private int start;
    /**
     * 返回记录数量 不传此参数默认返回全部
     */
    private int length;
}
