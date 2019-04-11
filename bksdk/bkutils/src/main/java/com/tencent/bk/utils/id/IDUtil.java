/*******************************************************************************
 * Copyright (c) 2005, 2017 tencent.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.tencent.bk.utils.id;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 封装各种生成唯一性ID算法的工具类.
 */
public class IDUtil {

    /**
     * 生成 UUID
     *
     * @return uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString();

    }

    /**
     * 随机生成一个0-Integer.MAX_VALUE 之间的正整型数
     *
     * @return 0-Integer.MAX_VALUE
     */
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
    }

    /**
     * 随机生成一个0-Long.MAX_VALUE 之间的正长整型数
     *
     * @return 0-Long.MAX_VALUE
     */
    public static long randomLong() {
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
}
