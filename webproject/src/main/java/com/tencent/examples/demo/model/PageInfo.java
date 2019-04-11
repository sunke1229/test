package com.tencent.examples.demo.model;

import com.tencent.bk.core.sdk.protocol.IResp;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageInfo<T> implements IResp<T> {
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
    private T rows;

    private Integer total;
    //private Integer rows;

    private T data;
}
