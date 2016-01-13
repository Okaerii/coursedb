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
      <a class="navbar-brand hidden-sm" href="/welcome/toregister" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-首页'])">注册</a></div>
  </div>
</div>

<div class="container" style="margin-top: 50px"  >
  <form class="form-signin" style="width: 300px" action="/welcome/login">
    <h2 class="form-signin-heading">登录</h2>
    <label for="inputEmail" class="sr-only">账号</label>
    <input type="text" name="name"id="inputEmail" class="form-control" placeholder="账号" required autofocus>
    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="密码" required>
    <button class="btn btn-success" type="submit" style="width: 300px">登录</button>
  </form>
</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
