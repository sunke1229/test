/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.api;

import com.tencent.bk.core.BkConsts;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@TestPropertySource("classpath:test.properties")
@RunWith(SpringRunner.class)
public class BaseClientTest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseClientTest.class);

    protected HttpServletRequest request = new MockHttpServletRequest();

    @Before
    public void setUp() {
        ((MockHttpServletRequest) request).setCookies(new Cookie(BkConsts.C_BK_TOKEN, bkToken));
    }

    @Value("${test.bk.token}")
    protected String bkToken;

    @Value("${test.bk.user}")
    protected String userName;

    @Value("${bk.paas.host}")
    protected String bkPaaSHost;
}
