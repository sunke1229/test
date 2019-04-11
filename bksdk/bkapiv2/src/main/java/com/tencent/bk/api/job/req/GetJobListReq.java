package com.tencent.bk.api.job.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.api.protocol.ApiReq;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetJobListReq extends ApiReq {

    /**
     * 必填：业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 作业名称
     */
    private String name;
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
     * 作业标签id. 1.未分类 2.运营发布 3.故障处理 4.常用工具 5.产品自助 6.测试专用 7.持续集成
     */
    @JsonProperty("tag_id")
    private String tagId;
    /**
     * 默认0表示从第1条记录开始返回
     */
    private int start;
    /**
     * 返回记录数量 不传此参数默认返回全部
     */
    private int length;
}
