<html>
<head>
    <!--UTF8声明-->
    <%@ page contentType="text/html; charset=UTF-8" %>
    <!--bootstrap核心文件css-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container" style="margin: 0%">
        <div class="navbar-header">
            <a class="navbar-brand hidden-sm" href="/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-首页'])">课程管理系统</a>
        </div>
    </div>
</div>

<div class="container-fluid" style="margin-top: 50px;padding: 0%" >
    <div class="row-fluid" >
        <div class="span12">
            <div class="row-fluid">
                <div class="col-md-2" style="padding: 0%;background-color: black">
                    <div class="row-fluid" >
                        <div class="row-fluid" >
                            <div class="span12">
                                <ul class="nav nav-list">
                                    <li class="active">
                                        <a href="#">首页</a>
                                    </li>
                                    <li>
                                        <a href="#">学生信息</a>
                                    </li>
                                    <li>
                                        <a href="#">已选课程</a>
                                    </li>
                                    <li>
                                        <a href="#">课程成绩</a>
                                    </li>
                                    <li>
                                        <a href="#">未选课程</a>
                                    </li>
                                    <li class="divider">
                                    </li>
                                    <li>
                                        <a href="#">帮助</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-md-8">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>
                                编号
                            </th>
                            <th>
                                产品
                            </th>
                            <th>
                                交付时间
                            </th>
                            <th>
                                状态
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                1
                            </td>
                            <td>
                                TB - Monthly
                            </td>
                            <td>
                                01/04/2012
                            </td>
                            <td>
                                Default
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
