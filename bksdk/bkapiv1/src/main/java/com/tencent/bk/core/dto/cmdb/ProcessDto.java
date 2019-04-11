/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 进程 信息
 */
@Getter
@Setter
public class ProcessDto implements Serializable {

    @JsonProperty("ApplicationName")
    private String applicationName;

    @JsonProperty("Source")
    private int source;

    @JsonProperty("InnerIP")
    private String ip;

    @JsonProperty("OuterIP")
    private String outerIp;

    @JsonProperty("ApplicationID")
    private int applicationId;

    @JsonProperty("Process")
    private List<ProcessInfoDto> process;

    @Getter
    @Setter
    public static class ProcessInfoDto implements Serializable {

        @JsonProperty("WorkPath")
        private String workPath;

        @JsonProperty("AutoTimeGap")
        private int autoTimeGap;

        @JsonProperty("LastTime")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Timestamp lastTime;

        @JsonProperty("StartCmd")
        private String startCmd;

        @JsonProperty("FuncID")
        private String funcID;

        @JsonProperty("BindIP")
        private String bindIP;

        @JsonProperty("FuncName")
        private String funcName;

        @JsonProperty("Flag")
        private String flag;

        @JsonProperty("User")
        private String user;

        @JsonProperty("StopCmd")
        private String stopCmd;

        @JsonProperty("ProcNum")
        private String procNum;

        @JsonProperty("ReloadCmd")
        private String reloadCmd;

        @JsonProperty("ProcessName")
        private String processName;

        @JsonProperty("OpTimeout")
        private int opTimeout;

        @JsonProperty("KillCmd")
        private String killCmd;

        @JsonProperty("Protocol")
        private String protocol;

        @JsonProperty("Seq")
        private String seq;

        @JsonProperty("ProcGrp")
        private String procGrp;

        @JsonProperty("Port")
        private int port;

        @JsonProperty("ReStartCmd")
        private String reStartCmd;

        @JsonProperty("AutoStart")
        private int autoStart;

        @JsonProperty("CreateTime")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Timestamp createTime;

        @JsonProperty("PidFile")
        private String pidFile;

        /**
         *  "WorkPath": "",
         "AutoTimeGap": "0",
         "LastTime": "2017-06-14 09:57:42",
         "StartCmd": "",
         "FuncID": "0",
         "BindIP": "10.0.0.1",
         "FuncName": "",
         "Flag": "",
         "User": "",
         "StopCmd": "",
         "ProcNum": "0",
         "ReloadCmd": "",
         "ProcessName": "nginx",
         "OpTimeout": "0",
         "KillCmd": "",
         "Protocol": "TCP",
         "Seq": "0",
         "ProcGrp": "",
         "Port": "80",
         "ReStartCmd": "",
         "AutoStart": "0",
         "CreateTime": "2017-06-14 09:55:02",
         "PidFile": ""
         */
    }
}
