/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class BaseClientTest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseClientTest.class);

    @Value("${test.bk.token}")
    protected String bkToken;

    @Value("${test.bk.user}")
    protected String userName;

}
