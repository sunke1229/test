/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.net;

import org.apache.commons.lang3.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * IP工具类
 */
public class IPUtil {

    /**
     * 取本地ip，先取eth1，如果没有取eth0，否则随便取一个
     *
     * @return
     */
    public static String getLocalAddress() {
        Map<String, String> machineIP = getMachineIP();
        String eth1 = machineIP.get("eth1");
        if (eth1 == null) {
            eth1 = machineIP.get("eth0");
        }
        if (eth1 == null) {
            if (!machineIP.values().isEmpty()) {
                eth1 = machineIP.values().iterator().next();
            }
        }
        return eth1;
    }

    /**
     * 获取当前服务器IP地址
     *
     * @return 返回当前服务器的网卡对应IP的MAP。
     */
    public static Map<String, String> getMachineIP() {
        Map<String, String> allIp = new HashMap<String, String>();

        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();// 获取服务器的所有网卡
            if (null != allNetInterfaces) {
                while (allNetInterfaces.hasMoreElements()) {// 循环网卡获取网卡的IP地址
                    NetworkInterface netInterface = allNetInterfaces.nextElement();
                    String netInterfaceName = netInterface.getName();
                    if (StringUtils.isNotBlank(netInterfaceName) && !"lo".equalsIgnoreCase(netInterfaceName)) {// 过滤掉127.0.0.1的IP
                        Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                        while (addresses.hasMoreElements()) {
                            InetAddress ip = addresses.nextElement();
                            if (ip != null &&
                                    !ip.isLinkLocalAddress() &&
                                    !ip.isLoopbackAddress() &&
                                    ip instanceof Inet4Address) {
                                String machineIp = ip.getHostAddress();
                                allIp.put(netInterfaceName, machineIp);
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }

        return allIp;
    }
}
