/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.service;

import com.tencent.examples.dto.RespDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;

/**
 *
 */
public interface BaseCommonService<T, ID extends Serializable> {


    RespDto<T> save(T userDto);

    RespDto<ID> delete(T userDto);

    RespDto<ID> delete(ID id);

    RespDto<T> get(ID id);

    /**
     * 列表查询
     *
     * @param spec
     * @param pageable
     * @return
     */
    RespDto<Page<T>> findAll(Specification<T> spec, Pageable pageable);
}
