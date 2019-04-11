/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.net;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


/**
 *
 */
public class IPUtilTest {
    @Test
    public void getLocalAddress() {
        String localAddress = IPUtil.getLocalAddress();
        System.out.println(localAddress);
        Assert.assertNotNull(localAddress);
    }

    @Test
    public void getMachineIP() {
        Map<String, String> machineIP = IPUtil.getMachineIP();
        Assert.assertFalse(machineIP.isEmpty());
    }

}