<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>蓝鲸开发框架:<sitemesh:write property='title' /></title>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="shortcut icon" href="${sessionScope.STATIC_URL}favicon.ico" type="image/x-icon">
    <!-- bootstrap css -->
    <link href="${sessionScope.STATIC_URL}assets/bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <!-- 禁止bootstrap 响应式 （app根据自身需求启用或禁止bootstrap响应式） -->
    <link href="${sessionScope.STATIC_URL}assets/bootstrap-3.3.4/css/bootstrap_noresponsive.css" rel="stylesheet">
    <!--自定义css-->
    <link href="${sessionScope.STATIC_URL}css/bk.css?v=${sessionScope.STATIC_VERSION}" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${sessionScope.STATIC_URL}css/index.css?v=${sessionScope.STATIC_VERSION}">
    <!-- 这个是全局配置，如果需要在js中使用app_id和site_url,则这个javascript片段一定要保留 -->
    <script type="text/javascript">
      var app_id = "${sessionScope.APP_ID}";
      var site_url = "${sessionScope.SITE_URL}";	  // app的url前缀,在ajax调用的时候，应该加上该前缀
      var static_url = "${sessionScope.STATIC_URL}"; // 静态资源前缀，在js中引用资源时要加上这个前缀
      </script>

      <!-- jquery js  -->
      <script src="${sessionScope.STATIC_URL}js/jquery-1.10.2.min.js" type="text/javascript"></script>
      <script src="${sessionScope.STATIC_URL}js/jquery.json-2.3.min.js" type="text/javascript"></script>
      <!-- bootstrap js  -->
      <script src="${sessionScope.STATIC_URL}assets/bootstrap-3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
      <!--配置js  勿删-->
      <script src="${sessionScope.STATIC_URL}js/settings.js?v=${sessionScope.STATIC_VERSION}" type="text/javascript"></script>

      <!--add start-->
      <script src="${sessionScope.STATIC_URL}demo/js/bootstrap-table.js"></script>
      <script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
      <link href="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.css" rel="stylesheet">
      <!-- 包括所有kendoui的js插件或者可以根据需要使用的js插件调用　-->
      <script src="https://magicbox.bkclouds.cc/static_api/v3/assets/kendoui-2015.2.624/js/kendo.all.min.js"></script>
      <!--add end-->


    <sitemesh:write property='head' />
  </head>
<body>
    <!--顶部导航 Start-->
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
    <!--顶部导航 End-->

    <!-- 固定宽度表单居中 start -->
		<sitemesh:write property='body' />
    <!-- 固定宽度表单居中 end -->

    <!-- 尾部声明 start -->
        <%@ include file="/WEB-INF/layouts/footer.jsp"%>
    <!-- 尾部声明 end -->
    <!-- 兼容性设置 -->
    <!--[if lt IE 6]>\xe8\x93\x9d\xe9\xb2\xb8\xe6\x99\xba\xe8\x90\xa5\x20\xe7\x89\x88\xe6\x9d\x83\xe6\x89\x80\xe6\x9c\x89<![endif]-->
</body>
</html>