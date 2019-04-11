<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>后台展示</title>
    <link href="https://magicbox.bkclouds.cc/static_api/v3/assets/fontawesome/css/font-awesome.css" rel="stylesheet">
</head>


<body>
<div style="height: 10px"></div>

<div id="wrapper">
    <!-- Navigation 上中 -->

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <!-- /.row -->
            <div class="row data-panel">
                <div class="col-lg-3 col-md-6">
                    <div class="king-widget2">
                        <div class="king-widget-content p20 bg-info">
                            <div class="king-counter king-counter-lg">
                                <div class="king-counter-label text-uppercase f16">we have</div>
                                <div class="king-counter-number-group">
                                    <span class="king-counter-number white"  id="app_count">0</span>
                                    <span class="king-counter-icon ml10 white">
                                            <i class="glyphicon glyphicon-folder-open"></i>
                                        </span>
                                </div>
                                <div class="king-counter-label text-uppercase f16">业务</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="king-widget2">
                        <div class="king-widget-content p20 bg-info">
                            <div class="king-counter king-counter-lg">
                                <div class="king-counter-label text-uppercase f16">we have</div>
                                <div class="king-counter-number-group">
                                    <span class="king-counter-number white"  id="lightapp_count">0</span>
                                    <span class="king-counter-icon ml10 white">
                                            <i class="glyphicon glyphicon-phone"></i>
                                        </span>
                                </div>
                                <div class="king-counter-label text-uppercase f16">轻应用</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="king-widget2">
                        <div class="king-widget-content p20 bg-info">
                            <div class="king-counter king-counter-lg">
                                <div class="king-counter-label text-uppercase f16">we have</div>
                                <div class="king-counter-number-group">
                                    <span class="king-counter-number white"  id="user_count">0</span>
                                    <span class="king-counter-icon ml10 white">
                                        <i class="glyphicon glyphicon-user"></i>
                                    </span>
                                </div>
                                <div class="king-counter-label text-uppercase f16">用户</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="king-widget2">
                        <div class="king-widget-content p20 bg-info">
                            <div class="king-counter king-counter-lg">
                                <div class="king-counter-label text-uppercase f16">we have</div>
                                <div class="king-counter-number-group">
                                    <span class="king-counter-number white" id="job_count">0</span>
                                    <span class="king-counter-icon ml10 white">
                                        <i class="glyphicon glyphicon-wrench"></i>
                                    </span>
                                </div>
                                <div class="king-counter-label text-uppercase f16">常用作业</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row charts">
                <div class="col-md-6 ">
                    <div class="king-block king-block-bordered mb30">
                        <div class="king-block-header">
                            <h3 class="king-block-title">作用分布</h3>
                        </div>
                        <div class="king-block-content">
                            <div class="chart" id="chartD" style="height: 360px"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="king-block king-block-bordered mb30">
                        <div class="king-block-header">
                            <h3 class="king-block-title">业务主机数量</h3>
                        </div>
                        <div class="king-block-content">
                            <div class="chart" id="chartC" style="height: 360px"></div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->


<script type="text/javascript">
    $(document).ready(function() {
        $("#background-tab").addClass("king-navbar-active");

        $.ajax({
            url: "${sessionScope.SITE_URL}rest/user/chartc",
            contentType:"application/json;charset=UTF-8",
            type:"post",
            dataType:"json",
            success:function (data) {
                $('#chartC').kendoChart({
                    legend:{
                        position : "bottom"
                    },
                    theme : 'bootstrap',
                    seriesDefaults: {
                        labels: {
                            //template: "#= category # - #= kendo.format('{0:P}', percentage)#",
                            template: "#= category # - #= value #"+'台',
                            position: "outsideEnd",
                            visible: true,
                            background: "transparent"
                        }
                    },
                    series: [{
                        name: '访问来源',
                        type: 'pie',
                        data: data
                    }]
                });

            }
        })


        $.ajax({
            url: "${sessionScope.SITE_URL}rest/user/joblist",
            contentType:"application/json;charset=UTF-8",
            type:"post",
            dataType:"json",
            success:function (data) {
                $('#chartD').kendoChart({
                    seriesDefaults: {
                        type: 'column'
                    },
                    legend:{
                        position : "bottom"
                    },
                    theme : 'bootstrap',
                    tooltip: {
                        visible: true,
                    },
                    categoryAxis: {
                        categories: data.appnames,
                        majorGridLines: {
                            visible: false
                        }
                    },
                    series: [{
                        name: data.name,
                        data: data.counts
                    }]
                });

            }
        })


        $.ajax({
            url: "${sessionScope.SITE_URL}rest/user/summary",
            contentType:"application/json;charset=UTF-8",
            type:"post",
            dataType:"json",
            success:function (data) {
                $("#job_count").html(data.job_count);
                $("#app_count").html(data.app_count);
                $("#lightapp_count").html(data.lightapp_count);
                $("#user_count").html(data.user_count);
            }
        })

    });


    //重新绘制
    $(window).on('resize',function(){
        var chartC = $("#chartC").data("kendoChart");
        var chartD = $("#chartD").data("kendoChart");

        chartC.redraw();
        chartD.redraw();
    });

</script>

</body>

</html>