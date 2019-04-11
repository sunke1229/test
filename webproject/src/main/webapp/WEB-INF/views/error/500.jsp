<%--
  ~  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>应用异常(500页)</title>
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
<div class="king-exception-box king-500-page">
    <img src="/static/img/expre_500.png">
    <h1>应用出现异常</h1>
    <p>努力恢复中，请稍后再试......</p>
    <p>${message}</p>
</div>
</body>
</html>
