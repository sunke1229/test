<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>后台展示</title>

    <style type="text/css">
        .toast-center-center {
            top: 50%;
            left: 50%;
            margin-top: -25px;
            margin-left: -150px;
        }

    </style>
    <link href="https://magicbox.bkclouds.cc/static_api/v3/assets/fontawesome/css/font-awesome.css" rel="stylesheet">
</head>

<body>

<div id="wrapper">

    <div id="page-wrapper">

        <div class="container-fluid">

            <!-- Page Heading -->

            <!---->
            <div class="panel-body" style="padding-bottom:0px;">
                <div class="panel panel-default">
                    <div class="panel-heading">查询条件</div>
                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" for="bookid">书本ID</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="bookid">
                                </div>
                                <label class="control-label col-sm-1" for="bookname">书名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="bookname">
                                </div>
                                <div class="col-sm-4" style="text-align:left;">
                                    <%--<button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>--%>
                                    <button type="button" style="margin-left:50px" id="reset" class="btn btn-primary">重置</button>
                                    <button type="button" style="margin-left:50px" id="chaxun" class="btn btn-primary">查询</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>

                <div id="toolbar" class="btn-group">
                    <button id="btn_add" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                    </button>
                    <button id="btn_edit" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                    </button>
                    <button id="btn_delete" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                    </button>
                </div>
                <table id="tb_departments"></table>
            </div>

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->

</div>

<!-- /.弹出框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <label for="id">I&nbsp;&nbsp;D</label>
                    <input type="text" name="id" class="form-control" id="id" placeholder="ID" value="" disabled>
                </div>
                <div class="form-group">
                    <label for="name">书名</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="书名" value="" >
                </div>
                <div class="form-group">
                    <label for="num">数量</label>
                    <input type="text" name="num" class="form-control" id="num" placeholder="数量" value="" >
                </div>
                <%--<div class="form-group">--%>
                <%--<label for="chname">中文名</label>--%>
                <%--<input type="text" name="chname" class="form-control" id="chname" placeholder="中文名" value="" >--%>
                <%--</div>--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
            </div>
        </div>
    </div>
</div>
<!-- /#wrapper -->




<link rel="stylesheet" href="${sessionScope.STATIC_URL}demo/css/bootstrap-editable.css">
<script src="${sessionScope.STATIC_URL}demo/js/bootstrap-editable.js"></script>
<script src="${sessionScope.STATIC_URL}assets/bootstrap-3.3.4/js/bootstrap-table-editable.js"></script>

<!-- /#提示框 -->
<script type="text/javascript" src="${sessionScope.STATIC_URL}demo/js/ewin.js"></script>
<script src="https://cdn.bootcss.com/toastr.js/2.0.0/js/toastr.js"></script>
<link href="https://cdn.bootcss.com/toastr.js/2.0.0/css/toastr.css" rel="stylesheet">


<script type="text/javascript">

    $(function () {
        $("#crud-tab").addClass("king-navbar-active");

        //toastr 弹窗插件
        toastr.options.positionClass="toast-center-center";
        toastr.options.timeOut=500;

        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

        //查询
        $("#chaxun").click(function(){
            oTable.Init();
        })

        $(window).resize(function () {
            $('#tb_departments').bootstrapTable('resetView');
        });
    });

    var limit ,offset;

    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $("#tb_departments").bootstrapTable('destroy');//第二次加载要先销毁
            $('#tb_departments').bootstrapTable({
                url: '${sessionScope.SITE_URL}rest/book/getAll',         //请求后台的URL（*）
                contentType: "application/json;charset=UTF-8",//必须要有！！！！
                method: 'get',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                dataField: "rows",
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                height:530,//高度调整
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 20],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                //showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                onEditableSave: function (field, row, oldValue, $el) {
                    $.ajax({
                        type: "post",
                        url: "${sessionScope.SITE_URL}rest/book/saveBook",
                        data: row,
                        success: function (data, status) {
                            if (status == "success") {
                                toastr.success('修改成功');
                            }
                        },
                        error: function () {
                            toastr.error('修改失败');
                        }
                    });
                },
                responseHandler:function (res) {
                    return res;
                },
                columns: [{
                    id:"",
                    checkbox: true
                },
                    {
                        title:'ID',
                        field:"id",
                        hidden:true,
                        sortable:true
                    },
                    {
                        title:'书名',
                        field:"name",
                        editable:true,

                    },
                    {
                        title:'数量',
                        field:"num",
                    }]
            });

        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            limit=params.limit;
            offset=params.offset;
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                departmentname: $("#txt_search_departmentname").val(),
                statu: $("#txt_search_statu").val(),
                search: params.search,
                bookname:$("#bookname").val(),
                bookid:$("#bookid").val()
            };
            return temp;
        };
        return oTableInit;
    };

    //tableHeight函数
    function tableHeight(){
        //可以根据自己页面情况进行调整
        return $(window).height() -420;
    }

    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
            $("#btn_add").click(function () {
                $("#myModalLabel").text("新增");
                $("#myModal").find(".form-control").val("");
                $('#myModal').modal()

                postdata.DEPARTMENT_ID = "";
            });

            $("#reset").click(function(){
                $("#bookid").val("");
                $("#bookname").val("");
            });

            $("#btn_edit").click(function () {
                var arrselections = $("#tb_departments").bootstrapTable('getSelections');
                if (arrselections.length > 1) {
                    toastr.warning('只能选择一行进行编辑');
                    return;
                }
                if (arrselections.length <= 0) {
                    toastr.warning('请选择有效数据');
                    return;
                }
                $("#myModalLabel").text("编辑");
                $("#id").val(arrselections[0].id);
                $("#name").val(arrselections[0].name);
                $("#num").val(arrselections[0].num);
                //$("#txt_statu").val(arrselections[0].STATUS);
                $('#myModal').modal();
            });

            $("#btn_submit").click(function () {
                postdata.id = $("#id").val();
                postdata.name = $("#name").val();
                postdata.num = $("#num").val();
                $.ajax({
                    type: "post",
                    url: "${sessionScope.SITE_URL}rest/book/saveBook",
                    contentType:"application/x-www-form-urlencoded;charset=UTF-8",
                    data: $.parseJSON(JSON.stringify(postdata)),
                    success: function (data, status) {
                        if (status == "success") {
                            toastr.success('保存成功');
                            $("#tb_departments").bootstrapTable('refresh');
                        }
                    },
                    error: function () {
                        toastr.error('Error');
                    },
                    complete: function () {

                    }

                });
            });

            $("#btn_delete").click(function () {
                var arrselections = $("#tb_departments").bootstrapTable('getSelections');
                if (arrselections.length <= 0) {
                    toastr.warning('请选择有效数据');
                    return;
                }

                Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
                    if (!e) {
                        return;
                    }
                    var data1=JSON.stringify(arrselections);
                    $.ajax({
                        type: "post",
                        url: "${sessionScope.SITE_URL}rest/book/deleteByBooks",
                        data:  {"data":data1},
                        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
                        dataType:"json",
                        success: function (data, status) {
                            if (status == "success") {
                                toastr.success('删除数据成功');
                                $("#tb_departments").bootstrapTable('refresh');
                            }
                        },
                        error: function () {
                            toastr.error('Error');
                        },
                        complete: function () {

                        }

                    });
                });
            });

            $("#btn_query").click(function () {
                var bookname = $("#bookname").val();
                var bookid = $("#bookid").val();
                if(bookname=="" && bookid==""){
                    //return;
                    $("#tb_departments").bootstrapTable('refresh');
                }else {
                    $.ajax({
                        type: "get",
                        url: "${sessionScope.SITE_URL}rest/book/findbooksByNameAndID",
                        data: {"name" : bookname,
                            "id":bookid,
                            "limit":limit,
                            "offset":offset
                        },
                        dataType:"json",
                        success : function(data) {
                            if(data.total==0){
                                toastr.error('找不到记录');
                                $("#bookname").val("")
                                $("#bookid").val("")
                                $("#tb_departments").bootstrapTable('refresh');
                            }else {
                                $('#tb_departments').bootstrapTable({pageNumber:1,pageSize:10});
                                $("#tb_departments").bootstrapTable('load', data);//主要是要这种写法

                                //  $("#tb_departments").bootstrapTable({
                                //      pageNumber:1,                       //初始化加载第一页，默认第一页
                                //      height:tableHeight(),//高度调整
                                //      pageSize: 10,                       //每页的记录行数（*）
                                //      dataField: "rows",
                                //
                                //  },data);
                            }
                        }
                    });
                }

                //$("#tb_departments").bootstrapTable('refresh');
            });
        };

        return oInit;
    };
</script>



</body>

</html>