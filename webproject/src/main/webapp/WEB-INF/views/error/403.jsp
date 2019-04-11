<%--
  ~  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>您没有应用的访问权限(403页)</title>
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
    <img src="/static/img/expre_403.png">
    <p>${message}</p>
    <p>${requestScope.message}</p>
    <h1 style="font-size: 24px;">您没有应用的访问权限，请联系应用管理员添加</h1>
</div>
</body>

</html>