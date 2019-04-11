/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.base;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 */
public class BoolUtilTest {

    @Test
    public void isTrue() throws Exception {
        assertThat(BoolUtil.isTrue("true")).isTrue();
        assertThat(BoolUtil.isTrue("True")).isTrue();
        assertThat(BoolUtil.isTrue("tRUE")).isTrue();
        assertThat(BoolUtil.isTrue("abc")).isFalse();
        assertThat(BoolUtil.isTrue("false")).isFalse();
        assertThat(BoolUtil.isTrue("False")).isFalse();
        String bool = null;
        assertThat(BoolUtil.isTrue(bool)).isFalse();

        assertThat(BoolUtil.isTrue(true)).isTrue();
        assertThat(BoolUtil.isTrue(Boolean.TRUE)).isTrue();
        assertThat(BoolUtil.isTrue(false)).isFalse();
        assertThat(BoolUtil.isTrue(Boolean.FALSE)).isFalse();
        Boolean bool2 = null;
        assertThat(BoolUtil.isTrue(bool2)).isFalse();
    }


    @Test
    public void isFalse() throws Exception {

        assertThat(BoolUtil.isFalse("true")).isFalse();
        assertThat(BoolUtil.isFalse("True")).isFalse();
        assertThat(BoolUtil.isFalse("abc")).isTrue();
        assertThat(BoolUtil.isFalse("false")).isTrue();
        assertThat(BoolUtil.isFalse("False")).isTrue();

        assertThat(BoolUtil.isFalse(false)).isTrue();
        assertThat(BoolUtil.isFalse(true)).isFalse();
        assertThat(BoolUtil.isFalse(Boolean.TRUE)).isFalse();
        assertThat(BoolUtil.isFalse(Boolean.FALSE)).isTrue();
        Boolean bool = null;
        assertThat(BoolUtil.isFalse(bool)).isTrue();
        String bool2 = null;
        assertThat(BoolUtil.isFalse(bool)).isTrue();
    }

}