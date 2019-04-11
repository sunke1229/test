/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.utils.base;

/**
 *
 */
public class BoolUtil {

    public static boolean isTrue(Boolean bool) {
        return bool != null && bool;
    }

    public static boolean isTrue(String boolStr) {
        return Boolean.parseBoolean(boolStr);
    }

    public static boolean isFalse(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isFalse(String bool) {
        return !isTrue(bool);
    }
}
