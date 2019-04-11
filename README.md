# 蓝鲸Java开发框架

## 项目工程文件用途说明
本项目是一个多模块的Maven工程项目，下面介绍工程文件的规范，按规范来存放文件和开发
```
|-bksdk         蓝鲸提供的框架sdk，后续升级会覆盖该目录，不要修改避免引起冲突
    |-bkcore    蓝鲸sdk核心模块
    |-bkapiv1   蓝鲸云旧版API
    |-bkapiv2   蓝鲸云新版API（cc3.0）
    |-bkutils   蓝鲸常用工具模块等
    |-bkweb     蓝鲸web项目必须模块，包含认证等信息
|-webproject    蓝鲸开发示例Web工程模块，可直接在该项目上开发自己的app
    |-package               工程打包相关脚本配置文件（不要动）
        |- assemblies       Maven-assembly插件的打包配置存放目录 （不要动）
            |- assembly.xml 打包配置文件。不要改动打包范围，以免进行生产部署打包时出错
                                可增加自己的要打包的一些内容比如config目录
        |- scripts          各类控制脚本目录
            |- app.sh       程序的启停控制脚本，通过打包后解压后可在自己本地独立运行，注意不要修改。
        |- app.yml          这个是smart应用打包需要填写的一些信息描述文件，必填写
        |- bkjava.png       这个是示例的logo，命名方式是：以你项目的app_code命名的.png作为应用logo   
    |-src       各种源码（Java,js,css,html,jsp,xml,properties等配置文件所在目录） 
        |- test             测试代码和配置文件目录
            |- java         测试用例java源代码目录
            |- resources    测试配置文件                  
        |- main
            |- java         java源代码目录
            |- resources    配置文件目录
                |- application.properties               系统级通用配置-与部署所在环境无关的配置在这里设置
                |- application-development.properties   开发环境需要个性化的配置，例如数据库等和环境相关的
                |- application-testing.properties       测试环境需要个性化的配置，例如数据库等和环境相关的
                |- application-production.properties    生产环境需要个性化的配置，例如数据库等和环境相关的
                |- xxxx.properties                      可在BKWebApplication中可指定自己想要的配置文件
            |- webapp           web系统的主目录
                |- WEB-INF      jsp页面或模板文件存放位置
                        （建议jsp放在此处，再根据WebMvcConfiguration.java 配置映射）
                    |- layouts  jsp布局页面（siteMesh3 装饰布局引擎) 可根据自项目增改内容 
                        |- decorator.jsp    所有页面布局模板jsp
                        |- footor.jsp       页面底部布局模板jsp
                        |- header.jsp       页面顶部（菜单）布局模板jsp
                    |- views    各业务的主要页面jsp都放在
                |- static   web静态资源文件（html,css,js)
                    |- css
                    |- js   包含了蓝鲸的官方框架js，不要删除，需要在页面引用
                    |- demo 自带的示例demo的静态资源文件，如果不用示例可以安全删除

```
## 系统发布包结构说明
打包将会生成一个${project.name}-${project.version}.tgz的发布包，可独立手工部署，以下为一个示例：
```
bkjava-1.0.tgz
    |- bkjava
        |- bin              启停控制脚本的目录
            |- app.sh       控制启停脚本，本地测试部署用，不要修改否则可能在生产测试环境出现问题
        |- bkjava-exec.war  程序运行包。war包名称通过读取系统环境变量APP_ID变量。  
```
## 开发环境配置
### Lombok 模板代码生成库
我们项目用到了lombok，这是一个通过注解帮助用户在编译代码时为各种Bean生成构造方法/Getter/Setter/toString/equals等模板代码减少工程代码量
要实现他我们在pom中已经将依赖引入了，另一个需要开发者自己做的事是在自己的IDE开发工具中增加这个Lombok插件，如果不安装，IDE 则无法解析 lombok 注解。
lombok 的官方网址：http://projectlombok.org/
#### 配置IntelliJ IDEA Lombok 插件
    在 Preferences->plugins->Browse Repositories 搜索Lombok Plugin 安装后重启即可。
#### 配置Eclipse Lombok插件
- 进入官网下载 https://projectlombok.org/downloads/lombok.jar
- 将 lombok.jar 复制到 eclipse.ini 所在的文件夹目录下
- 打开 eclipse.ini，在最后面插入以下两行并保存：
```
    -Xbootclasspath/a:lombok.jar
    -javaagent:lombok.jar
```     
- 重启 eclipse / myeclipse

## 开发框架讲解
开发框架是基于Spring-Boot，当前稳定版本1.5.11。
配置即是代码，代码即是配置的风格，使用@Configuration的方式来配置和初始化Bean。
消除掉所有各种applicationxxxx.xml的Spring配置文件，当然框架也支持使用xml配置文件，两者可以达到共存，以兼容一些难以改造的老项目工程代码的引入。
    
### 框架入口启动类
* BkWebApplication 这个是SpringBoot的启动类，如果想改名，则需要连pom.xml中的mainClass也一并修改。
    * 通过@ImportResource 加载Spring的xml配置文件
    * 通过@EnableAutoConfiguration 来决定禁用springboot的哪些自动配置
* 具体由开发者去配置，类中有大量的JavaDoc说明。

### 核心初始化配置
- com.tencent.core 为核心类包，具体可以见每个包中的package-info.java的说明类
 
- 系统通过com.tencent.bk.sdk.init.CoreBeanConfiguration 初始化加载核心服务。
    - 如果开发者想通过xml配置，请直接将上述的配置通过xml来设置。
- 登录认证拦截器 LoginFilter 
    - 配置拦截uri通过application.properties中的app.filter.login.uri-patterns
- Csrf防攻击拦截器 CsrfFilter
    - 配置拦截uri通过application.properties中的app.filter.csrf.uri-patterns 

### 数据库说明
#### flyway migrations 数据库自动变更插件
    flyway 插件是帮助用户的数据库做升级变更的插件， 在程序启动时会根据定义好的规则来自动执行。
    规则是在src/main/resources/db/migration目录下创建按版本号递增命名的Sql文件，会递增执行。
    在程序打包时需要将此目录一并打包。
##### 使用准备工作
- 创建好业务数据库, 后面Flyway会自动从指定的业务数据库创建一张schema_version表记录执行情况。

- 配置好application-development.properties(开发)
  配置好application-testing.properties(测试)
  配置好application-production.properties(生产)
  文件中的业务数据库配置，根据前面创建的数据库指定进去。

- 创建 src/main/resources/db/migration 目录。

##### 编写SQL脚本
- 在src/main/resources/db/migration 目录下创建脚本
- 按版本升级的脚本：每个版本文件只允许执行一次，并且不允许进行修改，否则会启动失败。脚本名称
以V开头加版本号再后续连接两个_下划线做为分隔符号，例如：V1.0.1__init_table.sql 
- 检查脚本变化后重启系统后可重新执行的脚本：多用于开发环境或者用CREATE OR REPLACE 的方式进行无伤害的更新，脚本名称以R开头再后续连接两个_下划线做为分隔符号，
 例如： R__some_thing_replace.sql
 
##### 注意事项
- 按版本升级的脚本文件一旦被flyway执行后，就不允许再修改，否则程序启动时校验文件时会出错
- 如果是频繁修改，请创建可重复执行脚本来处理，并保存到最终版本。
  R__some_thing_to_desc.sql,R是可重复执行的脚本，但是必须不带版本号，否则也将和V一样不能重复执行并且也不能修改内容
- 如果不想使用migration自动升级数据库，请移走resources/db目录并注释掉pom.xml中的flyway

#### 统一会话 
统一会话采用spring-session来管理，并默认采用了和业务数据库相同的存储，会在Mysql中生成两张数据库表：spring_session 和 spring_session_attributes
##### 如何切换会话存储类型
- 见application.properties的spring.session.store-type配置项

### 1.开发项目webproject
#### 配置修改
- src/main/resources/application-testing.properties 文件：
    - 先创建好测试环境数据库(create database)，并修改相应信息
        - spring.datasource.url
        - spring.datasource.username
        - spring.datasource.password
- src/main/resources/application-production.properties 文件：
    - 先创建好测试生产数据库(create database)，并修改相应信息
        - spring.datasource.url
        - spring.datasource.username
        - spring.datasource.password
- src/main/resources/application-development.properties 文件：
    - app.id \ app.token （蓝鲸智云开发者中心->点击应用ID->基本信息 中可以查看到这两个值的信息
    - bk.paas.host（蓝鲸智云开发者中心的域名，形如：http://paas.blueking.com）
    - app.server.host
        本地开发环境自行配置Hosts调试，主域名为与paas开发环境一样，子域名可以自行设置,形如：http://bkjavadev.blueking.com:8080
    - 先创建好本地数据库(create database)，并修改相应信息
        - spring.datasource.url 
        - spring.datasource.username 
        - spring.datasource.password 
    - server.port（本地开发服务访问端口，默认8080，可以修改为指定的端口）
- pom.xml 文件：
    - pkg.app.id （填写你的应用ID，与上面的的app.id一样,否则会影响Smart应用和独立部署的打包部署）
- src/main/resource/logback-spring.xml
    - 这个文件为日志框架的入口配置文件，可以里面修改springProfile不同环境的配置日志级别
- package/app.yml 文件：
    - 这个文件是用于将本项目做成一个蓝鲸smart应用，需要按该文档上描述的正确填写，否则会导致Smart应用失败。
- 应用logo:
    - 将应用logo以当前应用的app_code命名成为 app_code.png，放package目录下，见bkjava.png这个默认的logo
    
- 开发框架示例的启动方式
    - 在IDE开发工具中 启动BKWebApplication即可。IDEA需要配置working directory为 $MODULE_DIR$
    - 通过命令行执行 mvn spring-boot:run 启动即可。（需要本地安装maven）
        - Maven下载地址http://maven.apache.org/surefire/download.cgi
        - bkjava/settings.xml
            - 需要加入开发者的私有仓库，并配置到IEDA中的maven作为配置文件，保证能下载到Maven依赖。
            
### 2.脱离蓝鲸独立部署
#### 2.1 配置修改
- 测试环境
    - src/main/resources/application-testing.properties 文件：
        - 增加app.server.host和bk.paas.host配置项，配置成对接你测试环境的该服务地址和对应蓝鲸平台测试环境地址（可以和生产共享）
        - 注释掉bk.context.pre.path 这个配置。
- 生产环境
    - src/main/resources/application-production.properties 文件：
        - 增加app.server.host和bk.paas.host配置项，配置成对接你测试环境的该服务地址和对应蓝鲸平台生产环境地址
        - 注释掉bk.context.pre.path 这个配置。

#### 2.2 工程打包

- 在工程根目录上运行  ```mvn clean package```
  会在工程根目录生成一个target目录，在target目录下会有一个以app.id变量命名的${app.id}-bin.tgz压缩包。
       
#### 2.3 部署

- 环境变量配置
    - 需要在部署服务器上增加以下环境变量（以生产为例）
        ```
        # 生产
        export BK_ENV=production
        # 你的APP_ID 和 token
        export APP_ID=bsop
        export APP_TOKEN=1
        # 日志目录
        export BK_LOG_DIR=/data/op/logs
        # 服务HTTP端口，如果不指定，默认是8080（在配置文件中有）
        export CONTAINER_PORT=80
        ```
- 将压缩包放到要部署的环境（LinuxServer），解压 tar -xvf ${app.id}-bin.tgz
      执行 ${app.id}/bin/app.sh start
- 问题定位
    - 服务启动不了，没有日志，请编辑 app.sh ,将 NOHUPLOG=nohup.out 注释放开，再启动后会有这个日志文件，可以查看错误 