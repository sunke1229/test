package com.tencent.bk.api.job.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Operation {

    @JsonProperty("operation_code")
    private int operationCode;

    @JsonProperty("operation_name")
    private String operationName;
}
