/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompanyDto implements Serializable {

    /**
     * "CompanyID": "0",
     * "AssetID": "",
     * "Region": "",
     * "Owner": "公司名称",
     * "PlatID": "1",
     * "ApplicationID": "2"
     */

    @JsonProperty("CompanyID")
    private int companyId;

    @JsonProperty("AssetID")
    private int assetID;

    @JsonProperty("Region")
    private String region;

    @JsonProperty("Owner")
    private String owner;

    @JsonProperty("PlatID")
    private int platId;

    @JsonProperty("ApplicationID")
    private int applicationId;
}
