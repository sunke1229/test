/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.core.sdk.protocol;

import lombok.Getter;
import lombok.Setter;

/**
 * ESB API请求响应报文
 */
@Setter
@Getter
public class ESBResp<T> implements IResp<T> {
    /**
     * 错误描述
     */
    private String message;
    /**
     * 0表示成功
     */
    private int code;
    /**
     * true表示成功
     */
    private Boolean result;
    /**
     * API返回的数据
     */
    private T data;
}
