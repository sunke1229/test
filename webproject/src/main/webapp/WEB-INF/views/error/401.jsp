<%--
  ~  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>应用未登录蓝鲸智云平台(401页)</title>
    <link href="/static/css/bk.css?v=1.0.1" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        body {
            min-width: initial !important;
            background: none;
        }
    </style>
</head>

<body style="font-family:Microsoft Yahei;" class="king-errorpage-middle">
<!--HTML-->
<div class="king-exception-box king-login-page">
    <img src="/static/img/expre_login.png">
    <h1>您需要登录蓝鲸智云</h1>
    <p>${message}</p>
    <a href="###" style="cursor:pointer;" onclick="window.top.location.reload()">立即登录</a>
</div>
</body>

</html>
