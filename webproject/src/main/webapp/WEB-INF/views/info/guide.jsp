<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>开发指引</title></head>
<body>
<script>
    $(document).ready(function() {
        $("#guide-tab").addClass("king-navbar-active");
    });
</script>
<div class="page_index">
    <!-- banner start -->
    <div class="getheadimg-box">
        <p class="guide-banner-title">开发指引</p>
        <p class="guide-banner-word">了解蓝鲸开发框架，从这里开始</p>

    </div>
    <!-- banner end -->
    <div class="container">
        <ul class="king-step3 king-step-primary">
            <li class="process-doing mt50 clearfix">
                <span class="outer-circle"></span>
                <div class="step-num step-num-top-line">1</div>
                <div class="step-text step-text-top">
                    <h4>本地开发环境安装</h4>
                    <div class="mt10 mb20 wm lh2">
                        1.IntelliJ IDEA开发工具下载
                        <a href="https://www.jetbrains.com/idea/download"
                           target="_blank">点击下载</a>
                        <br>
                        2. apache Maven 包依赖及构建工具下载
                        <a href="http://maven.apache.org/surefire/download.cgi"
                           target="_blank">点击下载</a>
                        <br>
                    </div>
                </div>
            </li>
            <li class="process-doing clearfix">
                <span class="outer-circle"></span>
                <div class="step-num">2</div>
                <div class="step-text">
                    <h4>开发项目</h4>
                    <div class="mt10 mb20 wm lh2">
                        <strong>1.配置修改</strong><br>
                        （1）src/main/resources/application-testing.properties 文件：<br>
                        spring.datasource.url \ spring.datasource.username \ spring.datasource.password <br>
                        （先创建好测试环境数据库(create database)，并修改相应信息）<br>
                        （2）src/main/resources/application-production.properties 文件：<br>
                        spring.datasource.url \ spring.datasource.username \ spring.datasource.password  <br>
                        （先创建好测试生产数据库(create database)，并修改相应信息）<br>
                        （3）src/main/resources/application-development.properties 文件：<br>
                        app.id \ app.token （蓝鲸智云开发者中心 -&gt; 点击应用ID -&gt; 基本信息 中可以查看到这两个值的信息）<br>
                        bk.paas.host（蓝鲸智云开发者中心的域名，形如：http://paas.blueking.com）<br>
                        app.server.host（本地开发环境自行配置Hosts调试，主域名为与paas开发环境一样，子域名可以自行设置,形如：http://bkjavadev.blueking.com:8080）<br>
                        spring.datasource.url \ spring.datasource.username \ spring.datasource.password  <br>
                        （先创建好本地数据库(create database)，并修改相应信息）<br>
                        server.port（本地开发服务访问端口，默认8080，可以修改为指定的端口）<br>
                         (4) pom.xml 文件：<br>
                        pkg.app.id （填写你的应用ID，与上面的的app.id一样）<br>
                         (5) src/main/resource/logback-spring.xml 文件：<br>
                        这个文件为日志框架的入口配置文件，可以里面修改springProfile不同环境的配置日志级别<br>
                         (6) package/app.yml 文件：<br>
                        这个文件是用于将本项目做成一个蓝鲸smart应用，需要按该文档上描述的正确填写，否则会导致Smart应用失败。<br>
                         (7) 应用logo：<br>
                        将应用logo以当前应用的app_code命名成为 app_code.png，放package目录下，见bkjava.png这个默认的logo<br>
                         (8) bkjava/settings.xml: <br>
                        需要加入开发者的私有仓库，并配置到IDEA中的maven作为配置文件，保证能下载到Maven依赖。<br>
                         (9) 本地运行开发框架:<br>
                        &nbsp;&nbsp;在IDE开发工具中 可以直接启动 BKWebApplication类, IDEA需要配置working directory为 $MODULE_DIR$ <br>
                        &nbsp;&nbsp;或者通过本地命令行执行 mvn spring-boot:run 启动。（需要本地安装maven）<br>
                        Maven下载地址http://maven.apache.org/surefire/download.cgi <br>
                        <p class="text-notice">注意：测试环境 和 正式环境 的数据库需要对 AppServer 授权</p>
                        <br>
                        <strong>3.开发框架</strong><br>
                        具体见工程里面的README.md 说明文档
                            <br>
                    </div>
                </div>
            </li>
            <li class="process-doing clearfix">
                <span class="outer-circle"></span>
                <div class="step-num">3</div>
                <div class="step-text-button-line">
                    <h4>部署项目</h4>
                    <div class="mt10 mb20 wm lh2">
                        <strong>通过蓝鲸智云开发者中心提供的“测试部署”、“正式部署”服务将应用部署到测试\正式环境中。</strong><br>
                        操作入口：蓝鲸智云开发者中心 -&gt; 点击应用名称 -&gt; 应用部署。 <br>
                        （1）测试部署：将应用代码在测试环境上进行部署，部署成功后就可以在测试环境中使用您的应用。<br>
                        （2）正式部署：将应用代码在正式环境上进行部署，部署成功后就可以在正式环境中使用您的应用。<br>
                        （3）下架操作：系统将应用代码从您选择的环境上撤销部署，届时用户将无法访问该应用，但是该应用的数据库依然保留。<br>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
</body>
</html>