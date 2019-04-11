/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.bean;

import com.google.common.collect.Lists;
import com.tencent.bk.utils.json.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class BeanUtilTest {
    private boolean equals(A a, B b) {
        return a.a == b.a && a.b.equals(b.b);
    }

    @Test
    public void map() {
        A a = new A();
        a.a = 1;
        a.b = "A";
        B b2 = BeanUtil.map(a, B.class);
        assertTrue(equals(a, b2));
        System.out.println(a.toString());
    }

    @Test
    public void mapList() {
        List<A> list = Lists.newArrayList();
        A a = new A();
        a.a = 1;
        a.b = "A";
        list.add(a);
        A a2 = new A();
        a2.a = 1;
        a2.b = "A";
        list.add(a2);

        List<B> bList = BeanUtil.mapList(list, B.class);
        assertEquals(list.size(), bList.size());

        for (int i = 0; i < bList.size(); i++) {
            assertTrue(equals(list.get(i), bList.get(i)));
        }

    }

    @Test
    public void copy() {
        A a = new A();
        a.a = 1;
        a.b = "A";
        B b2 = new B();
        b2.a = 2;
        b2.b = "B";
        BeanUtil.copy(a, b2);
        assertTrue(equals(a, b2));
    }

    @Getter
    @Setter
    public static class A {
        private int a;
        private String b;

        @Override
        public String toString() {
            return JsonUtil.toJson(this);
        }
    }

    @Getter
    @Setter
    public static class B {
        private int a;
        private String b;

        @Override
        public String toString() {
            return JsonUtil.toJson(this);
        }
    }


}