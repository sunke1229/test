/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.demo.service.impl;

import com.tencent.examples.common.aop.annotation.ServiceAop;
import com.tencent.examples.demo.model.Book;
import com.tencent.examples.demo.repository.BookRepository;
import com.tencent.examples.demo.service.BookService;
import com.tencent.examples.dto.RespDto;
import com.tencent.examples.helper.RespHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CURD Service示例
 */
@Service //用Spring的注解初始化以下Service类
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @ServiceAop
    public RespDto<Book> save(Book book) {
        Book save = bookRepository.save(book);
        if (save != null) {
            return RespHelper.ok(save);
        }
        return RespHelper.ok(null);
    }

    @Override
    @ServiceAop
    public RespDto<Integer> delete(Book book) {
        if (0 >= book.getId() && StringUtils.isBlank(book.getName())) {
            return RespHelper.fail(9999, "id和name同时不能为空！");
        }
        bookRepository.delete(book);
        return RespHelper.ok(book.getId());
    }

    @Override
    public RespDto<Integer> delete(Integer id) {
        if (id <= 0 ) {
            return RespHelper.fail(9999, "id值不正确！");
        }
        bookRepository.delete(id);
        return RespHelper.ok(id);
    }

    @Override
    @ServiceAop
    public RespDto<Book> get(Integer id) {
        Book book = bookRepository.getOne(id);
        if (book == null) {
            return RespHelper.ok(null);
        }
        return RespHelper.ok(book);
    }

    @Override
    @ServiceAop
    public RespDto<Book> findByName(String name) {
        Book book = bookRepository.findBookByName(name);
        if (book == null) {
            return RespHelper.ok(null);
        }
        return RespHelper.ok(book);
    }

    @Override
    @ServiceAop
    public RespDto<List<Book>> findByLikeName(String name) {
        List<Book> books = bookRepository.findBooksByNameIsLike("%"+name+"%");
        return RespHelper.ok(books);
    }

    @Override
    public RespDto<List<Book>> deteleByBooks(List<Book> books) {
        bookRepository.delete(books);
        return null;
    }

    @Override
    public RespDto<List<Book>> findbooksByNameAndID(Integer id,String name) {
        List<Book> books = bookRepository.findBooksByIdAndNameIsLike(id,"%"+name+"%");
        return RespHelper.ok(books);
    }

    @Override
    @ServiceAop
    public RespDto<Page<Book>> findAll(Specification<Book> spec, Pageable pageable) {
        Page<Book> page = bookRepository.findAll(spec, pageable);
        return RespHelper.ok(page);
    }
}
