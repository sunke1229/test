/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.demo.service;

import com.tencent.examples.common.aop.annotation.ServiceAop;
import com.tencent.examples.dto.RespDto;
import com.tencent.examples.demo.model.User;
import com.tencent.examples.service.BaseCommonService;

import java.util.List;

/**
 *
 */
public interface UserService extends BaseCommonService<User, Integer> {

    @ServiceAop
    RespDto<User> findByUsername(String username);

    RespDto<List<User>> findByChname(String chname);

}
