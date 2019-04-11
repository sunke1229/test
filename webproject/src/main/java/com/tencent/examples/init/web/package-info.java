/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

/**
 * 此目录存放Web系统的配置，接口Json序列化，Tomcat容器等Bean初始化等
 * <p>
 * EmbedTomcatConfiguration.java 是必须有的类，他帮助你生成tomcat的access访问日志并由平台收集日志提供给你查询。
 * SiteMeshConfiguration.java 是装饰器SiteMesh3的配置类，如果不想用SiteMesh3，可以删除后自引入框架。
 * WebMvcConfiguration.java 是SpringMVC的配置类， 需要特别注意一些纯jsp模块页面（无后台写数据到jsp页面的可不定义Controller，
 *  直接在里面的addViewControllers方法追加
 */
package com.tencent.examples.init.web;