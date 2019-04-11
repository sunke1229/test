/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.id;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class IDUtilTest {
    @Test
    public void uuid() {
        Assert.assertNotNull(IDUtil.uuid());
    }

    @Test
    public void randomInt() {
        Assert.assertTrue(IDUtil.randomInt() >= 0);
    }

    @Test
    public void randomLong() {
        Assert.assertTrue(IDUtil.randomLong() >= 0);
    }

}