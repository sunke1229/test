/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.bean;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.List;

/**
 * Bean深拷贝及对象转换的工具类
 * 封装自Dozer， 有兴趣的也可使用orika，各有千秋。
 */
public class BeanUtil {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    /**
     * 转换对象的类型.
     *
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> targetClass) {
        return mapper.map(source, targetClass);
    }

    /**
     * 转换集合中对象的类型.
     *
     * @param sourceList
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> targetClass) {
        List<T> destinationList = Lists.newArrayListWithCapacity(sourceList.size());
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, targetClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 将对象A的值深拷贝到对象B中.
     *
     * @param source
     * @param targetClass
     */
    public static void copy(Object source, Object targetClass) {
        mapper.map(source, targetClass);
    }
}

