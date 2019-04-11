/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 作业的执行IP日志
 * {
 * "isFinished": true,
 * "stepInstanceName": "读取文件",
 * "stepAnalyseResult": [
 * {
 * "count": "1",
 * "resultType": 9,
 * "ipLogContent":
 * [
 * {
 * "status": 9,
 * "totalTime": 0.24799999594688416,
 * "stepInstanceId": 156965,
 * "isJobIp": 1,
 * "ip": "xxx.xxx.xxx.xxx",
 * "errCode": 0,
 * "source": 1,
 * "logContent": "QlpoOTFBWSZTWekFHDQAGcHf+XMyQA...",
 * "startTime": "2016-06-12 14:29:39",
 * "retryCount": 0,
 * "endTime": "2016-06-12 14:29:39",
 * "exitCode": 0
 * }
 * ],
 * "resultTypeText": "执行成功"
 * }
 * ],
 * "stepInstanceId": 156965,
 * "stepInstanceStatus": 3
 * }
 */
@Getter
@Setter
public class TaskIpLogDto implements Serializable {

    @JsonProperty("isFinished")
    private boolean finished;

    private String stepInstanceName;

    private int stepInstanceId;

    private int stepInstanceStatus;

    private List<StepAnalyseResultDto> stepAnalyseResult;

    @Getter
    @Setter
    public static class StepAnalyseResultDto implements Serializable {
        private int count;
        private int resultType;
        private List<StepLogContentDto> ipLogContent;
        private String resultTypeText;

        @Getter
        @Setter
        public static class StepLogContentDto implements Serializable {
            private int status;
            private double totalTime;
            private int stepInstanceId;
            private int isJobIp;
            private String ip;
            private int errCode;
            private int source;
            private String logContent;
            private String startTime;
            private String endTime;
            private int retryCount;
            private int exitCode;
        }
    }
}
