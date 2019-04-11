/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.demo.service;

import com.tencent.examples.common.aop.annotation.ServiceAop;
import com.tencent.examples.demo.model.Book;
import com.tencent.examples.dto.RespDto;
import com.tencent.examples.service.BaseCommonService;

import java.util.List;

/**
 *
 */
public interface BookService extends BaseCommonService<Book, Integer> {

    @ServiceAop
    RespDto<Book> findByName(String name);

    RespDto<List<Book>> findByLikeName(String name);

    RespDto<List<Book>> deteleByBooks(List<Book> books);

    RespDto<List<Book>> findbooksByNameAndID(Integer id,String name);


}
