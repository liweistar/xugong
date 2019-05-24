<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17489
  Date: 2019/5/12
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<script>
    $(function () {
        $(".pimg").die('click').live('click', function () {
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });
    });

    function imgShow(outerdiv, innerdiv, bigimg, _this) {
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性

        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
        $("<img/>").attr("src", src).load(function () {
            var windowW = $(window).width();//获取当前窗口宽度
            var windowH = $(window).height();//获取当前窗口高度
            var realWidth = this.width;//获取图片真实宽度
            var realHeight = this.height;//获取图片真实高度
            var imgWidth, imgHeight;
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

            if (realHeight > windowH * scale) {//判断图片高度
                imgHeight = windowH * scale;//如大于窗口高度，图片高度进行缩放
                imgWidth = imgHeight / realHeight * realWidth;//等比例缩放宽度
                if (imgWidth > windowW * scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW * scale;//再对宽度进行缩放
                }
            } else if (realWidth > windowW * scale) {//如图片高度合适，判断图片宽度
                imgWidth = windowW * scale;//如大于窗口宽度，图片宽度进行缩放
                imgHeight = imgWidth / realWidth * realHeight;//等比例缩放高度
            } else {//如果图片真实高度和宽度都符合要求，高宽不变
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
            $(bigimg).css("width", imgWidth);//以最终的宽度对图片缩放

            var w = (windowW - imgWidth) / 2;//计算图片与窗口左边距
            var h = (windowH - imgHeight) / 2;//计算图片与窗口上边距
            $(innerdiv).css({"top": h, "left": w});//设置#innerdiv的top和left属性
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg

        });

        $(outerdiv).click(function () {//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }

    $(function a() {
        $.ajax({
            url: "${pageContext.request.contextPath }/make/table",
            type: "POST",
            dataType: 'json',
            data: {
                "recive": "不可领取"
            },
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>"
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/recive?code=" + el.code + "'>领取</a></td>";
                    result += "</tr>";
                });
                $("#list1").html(result);
            },
            error: function () {
                alert("失败")
            },

        })
    });
    //自动显示所有
    $(function aa() {
        $.ajax({
            url: "${pageContext.request.contextPath }/make/status",
            type: "POST",
            dataType: 'json',
            data: {},
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>"
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>通过</a><a href='${pageContext.request.contextPath}/make/fall?code=" + el.code + "'>未通过</a></td>";
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            },

        })
    });
    // 点击查询所有
    $("#all").die('click').live('click', function () {
        $.ajax({
            url: "${pageContext.request.contextPath }/make/status",
            type: "POST",
            dataType: 'json',
            data: {},
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>"
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>通过</a><a href='${pageContext.request.contextPath}/make/fall?code=" + el.code + "'>未通过</a></td>";
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            error: function () {
                alert("失败")
            },

        })
    });
    //点击通过
    $("#pass").die('click').live('click', function () {
        $.ajax({
            url: '${pageContext.request.contextPath }/make/pass',
            data: {},
            dataType: 'json',
            error: function () {
                alert("请求出错.")
            },
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>"
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>通过</a><a href='${pageContext.request.contextPath}/make/fall?code" + el.code + "'>未通过</a></td>";
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            type: 'POST'
        })
    });
    //点击未通过
    $("#fall").die('click').live('click', function () {
        var code = $("input[name='code']").val().trim();
        $.ajax({
            url: '${pageContext.request.contextPath }/make/fall',
            data: {
                "code": code
            },
            dataType: 'json',
            error: function () {
                alert("请求出错.")
            },
            success: function (data) {
                var result = "";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>";
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>通过</a><a href='${pageContext.request.contextPath}/make/fall?code=" + el.code + "'>未通过</a></td>";
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            type: 'POST'
        })
    });
    $("#selbtn1").die('click').live('click', function () {
        $.ajax({
            url: '${pageContext.request.contextPath }/make/selbtn1',
            data: {
                "reviewe": "待审核"
            },
            dataType: 'json',
            error: function () {
                alert("请求出错.")
            },
            success: function (data) {
                var result = "";
                var a = "";
                a += "<thead>";
                a += "<tr>";
                a += "<th>学号</th>";
                a += "<th>姓名</th>";
                a += "<th>手机号</th>";
                a += "<th>身份证照片</th>";
                a += "<th>处理</th>";
                a += "<th>审核</th>";
                a += "<th>操作</th>";
                a += "</tr>";
                a += "</thead>";
                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>";
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>通过</a><a href='${pageContext.request.contextPath}/make/fall?code=" + el.code + "'>未通过</a></td>";
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            type: 'POST'
        })
    });
    $("#selbtn2").die('click').live('click', function () {
        $.ajax({
            url: '${pageContext.request.contextPath }/make/selbtn1',
            data: {
                "reviewe": "已审核"
            },
            dataType: 'json',
            error: function () {
                alert("请求出错.")
            },
            success: function (data) {
                var result = "";

                $.each(data, function (i, el) {
                    result += "<tr>";
                    result += "<td>" + el.code + "</td>";
                    result += "<td>" + el.name + "</td>";
                    result += "<td>" + el.number + "</td>";
                    result += "<td><img class='pimg' src='/pic/" + el.img + "' width=100 height=100></td>";
                    result += "<td>" + el.handle + "</td>";
                    result += "<td>" + el.reviewe + "</td>";
                    result += "<td>" + el.recive + "</td>";
                    result += "<td><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>通过</a><a href='${pageContext.request.contextPath}/make/pass?code=" + el.code + "'>未通过</a></td>";
                    result += "</tr>";
                });
                $("#list").html(result);
            },
            type: 'POST'
        })
    });

    function exportAchievementExcel() {
        $.post("/make/excel", $(".achievement-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "/common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                alert("失败")
            }
        });
    }
</script>

<head>
    <title>补办</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="container">
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>审核表</small>
                    </h1>
                </div>
            </div>
        </div>
        <body>
        <input class="btn btn-primary" type="button" value="查询待审核" id="selbtn1"/>
        <input class="btn btn-primary" type="button" value="查询已审核" id="selbtn2"/>
        <input class="btn btn-primary" type="button" value="查询所有" id="all"/>

        <table class="table table-hover table-striped">

            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>手机号</th>
                <th>身份证照片</th>
                <th>处理</th>
                <th>审核</th>
                <th>是否可领取</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="list"></tbody>
        </table>

        <div id="data-table_filter" class="dataTables_filter">
            <form class="achievement-table-form">
            </form>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>补办表</small>
                    </h1>
                </div>
            </div>
        </div>
        <a class="btn btn-primary" href="javascript:void(0)" class="dropdown-item" data-table-action="excel" onclick="exportAchievementExcel()">
            生成报表
        </a>
        <table class="table table-hover table-striped">


            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>手机号</th>
                <th>身份证照片</th>
                <th>可否领取</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="list1"></tbody>
        </table>

        <div id="outerdiv"
             style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv" style="position:absolute;">
                <img id="bigimg" style="border:5px solid #fff;" src=""/>
            </div>
        </div>

        <br/>
        </body>
    </div>
</div>
</html>
