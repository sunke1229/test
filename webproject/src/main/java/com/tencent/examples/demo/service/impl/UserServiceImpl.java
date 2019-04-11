/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.demo.service.impl;

import com.tencent.examples.common.aop.annotation.ServiceAop;
import com.tencent.examples.dto.RespDto;
import com.tencent.examples.helper.RespHelper;
import com.tencent.examples.demo.model.User;
import com.tencent.examples.demo.repository.UserRepository;
import com.tencent.examples.demo.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @ServiceAop
    public RespDto<User> save(User user) {
        User save = userRepository.save(user);
        if (save != null) {
            return RespHelper.ok(save);
        }
        return RespHelper.ok(null);
    }

    @Override
    @ServiceAop
    public RespDto<Integer> delete(User user) {
        if (0 >= user.getId() && StringUtils.isBlank(user.getUsername())) {
            return RespHelper.fail(9999, "id和username同时不能为空！");
        }
        userRepository.delete(user);
        return RespHelper.ok(user.getId());
    }

    @Override
    public RespDto<Integer> delete(Integer id) {
        if (id <= 0 ) {
            return RespHelper.fail(9999, "id值不正确！");
        }
        userRepository.delete(id);
        return RespHelper.ok(id);
    }

    @Override
    @ServiceAop
    public RespDto<User> get(Integer id) {
        User user = userRepository.getOne(id);
        if (user == null) {
            return RespHelper.ok(null);
        }
        return RespHelper.ok(user);
    }

    @Override
    @ServiceAop
    public RespDto<User> findByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return RespHelper.ok(null);
        }
        return RespHelper.ok(user);
    }

    @Override
    @ServiceAop
    public RespDto<List<User>> findByChname(String chname) {
        List<User> users = userRepository.findUsersByChnameIsLike(chname);
        return RespHelper.ok(users);
    }

    @Override
    @ServiceAop
    public RespDto<Page<User>> findAll(Specification<User> spec, Pageable pageable) {
        Page<User> page = userRepository.findAll(spec, pageable);
        return RespHelper.ok(page);
    }
}
