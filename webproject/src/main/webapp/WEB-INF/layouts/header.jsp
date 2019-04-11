<%@ page contentType="text/html;charset=UTF-8"%>
<nav class="navbar navbar-default king-horizontal-nav2 navbar-mt0" role="navigation">
        <div class="container" style="width: 100%;">
            <div class="navbar-header col-md-4 col-sm-4 col-xs-4 logo">
                <a class="navbar-brand" href="${sessionScope.SITE_URL}">
                    蓝鲸智云开发框架
                </a>
            </div>
            <div class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav">
                  <li id="home-tab"><a href="${sessionScope.SITE_URL}"><span>首页</span></a></li>
                  <li id="guide-tab"><a href="${sessionScope.SITE_URL}info/guide"><span>开发指引</span></a></li>
                  <li id="background-tab"><a href="${sessionScope.SITE_URL}demo/backstage"><span>后台展示</span></a></li>
                  <li id="crud-tab"><a href="${sessionScope.SITE_URL}demo/tables"><span>表格示例</span></a></li>
                  <li id="contactus-tab"><a href="${sessionScope.SITE_URL}info/contactUs"><span>联系我们</span></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <a href="###" class="avatar">
                    <img src="${sessionScope.STATIC_URL}img/getheadimg.jpg" width="40" alt="Avatar" class="avatar-img">
                    <span>${sessionScope.user.chname}</span>
                  </a>
                  <!--退出登录-->
                  <a id="logout" href="${sessionScope.SITE_URL}rest/user/logout">注销</a>
                </ul>
            </div>
        </div>
    </nav>
