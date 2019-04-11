/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.init.web;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * 必须有的帮助Tomcat打出logback格式的日志
 */
@Configuration
public class EmbedTomcatConfiguration {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) container;
                LogbackValve logbackValve = new LogbackValve();
                logbackValve.setFilename("logback-access.xml");
                containerFactory.setContextValves(Collections.singletonList(logbackValve));
            }
        };
    }
}