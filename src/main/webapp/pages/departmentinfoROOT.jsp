<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a href="#">${userObj.id}</a>
                  </li>
                  <li>
                    <a href="/root/teacher/info">教师信息</a>
                  </li>
                  <li>
                    <a href="/root/students/info">学生信息</a>
                  </li>
                  <li>
                    <a href="/root/course/info">课程信息</a>
                  </li>
                  <li>
                    <a href="/root/classroom/info">教室信息</a>
                  </li>
                  <li>
                    <a href="/root/teacher/evaluate">教师评价</a>
                  </li>
                  <li>
                    <a href="/root/class/info">班级信息</a>
                  </li>
                  <li>
                    <a href="/root/grade/info">成绩信息</a>
                  </li>
                  <li>
                    <a href="/root/department/info">院系信息</a>
                  </li>
                  <li class="divider">
                  </li>
                  <li>
                    <a href="/welcome/logout">登出</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>

        </div>
        <div class="col-md-8">
            <table class="table table-striped table-condensed" >
              <thead>
              <tr>
                <th>
                  系号
                </th>
                <th>
                  系名
                </th>
                <th>
                  系主任
                </th>
                <th>
                  主任电话
                </th>
                <th>
                  操作
                </th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="department" items="${departmentes}">
                <tr>
                  <td>
                      ${department.id}
                  </td>
                  <td>
                      ${department.name}
                  </td>
                  <td>
                      ${department.chairman}
                  </td>
                  <td>
                      ${department.phonenum}
                  </td>
                  <td><form style="margin-bottom: 0em" method="post" action="/root/department/delete/${department.id}"><button class="btn btn-success btn-xs" type="submit" >删除</button></form></td>
                </tr>
              </c:forEach>
              <tr>
                <form action="/root/department/add" method="post">
                  <td><input type="text" name="id" class="form-control" required autofocus></td>
                  <td><input type="text" name=name" class="form-control" required autofocus></td>
                  <td><input type="number" name="chairman"class="form-control"></td>
                  <td><input type="number" name="phonenum"class="form-control"></td>
                  <td><button class="btn btn-success btn-xs" type="submit" >添加/修改</button></td>
                </form>
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
