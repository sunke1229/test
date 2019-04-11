/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.helper;

import com.tencent.examples.dto.RespDto;

/**
 *
 */
public class RespHelper {

    public static <T> RespDto<T> createEmptyRespDto() {
        return new RespDto<>();
    }


    public static <T> RespDto<T> fail(int code, String message) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(code);
        t.setMessage(message);
        return t;
    }

    public static <T> RespDto<T> ok(T data) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(0);
        t.setData(data);
        return t;
    }

}
