package com.tencent.bk.utils.string;

public class StringUtil {

    public static boolean isBlank(String str) {
        return  str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return  str != null && str.trim().length() > 0;
    }

}
