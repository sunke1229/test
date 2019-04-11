/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.dto.login;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 蓝鲸平台用户信息
 * {
 * <p>
 * "username": "admin",
 * "qq": "12345",
 * "role": 1,
 * "phone": "12345678911",
 * "email": "11@qq.com",
 * "chname": "admin",
 * }
 */
@Getter
@Setter
public class BkUserDto implements Serializable {

    private String username;
    private int role;
    private String qq;
    private String phone;
    private String email;
    private String chname;
}
