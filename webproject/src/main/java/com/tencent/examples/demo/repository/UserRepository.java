/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.demo.repository;

import com.tencent.examples.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository //表示是一个DAO
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

    User findUserByUsername(String userName);

    List<User> findUsersByChnameIsLike(String chname);
}
