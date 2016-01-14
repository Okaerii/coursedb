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
                    <a href="/student/info">学生信息</a>
                  </li>
                  <li>
                    <a href="/student/course/chosen">已选课程</a>
                  </li>
                  <li>
                    <a href="/student/course/grade">课程成绩</a>
                  </li>
                  <li>
                    <a href="/student/course/unchosen">未选课程</a>
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
                学号
              </th>
              <th>
                姓名
              </th>
              <th>
                年龄
              </th>
              <th>
                性别
              </th>
              <th>班级</th>
              <th>系</th>
            </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                    ${student.id}
                </td>
                <td>
                    ${student.name}
                </td>
                <td>
                    ${student.age}
                </td>
                <td>
                    ${student.gender}
                </td>
                <td>
                    ${student.classid.id}
                </td>
                <td>${student.classid.departmentid}</td>
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
