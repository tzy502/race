<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
</head>
<%@ include file="title.jsp"%>
<body>
	<nav>
    <div class=" grey lighten-1 nav-wrapper">
      <div class="col s4 offset-s1">
      	你所在位置：
        <a href="index.jsp" class="breadcrumb">首页</a>
        <a href="#" class="breadcrumb">修改密码</a>
      </div>
    </div>
  </nav>
  <center>
     	<form action="modifypwd.do" method="post">
		帐号:<%=user.getUserid() %><br />
		<div class="row">
		<div class="input-field col s4 offset-s4">旧密码:<input type="password" name="oldpwd"></div>
		</div>
		<div class="row">
		<div class="input-field col s4 offset-s4">新密码:<input type="password" name="newpwd1"></div>
		</div>
		<div class="row">
		<div class="input-field col s4 offset-s4">重复新密码:<input type="password" name="newpwd2"></div>	
		</div>
            <input type="submit" class="waves-effect waves-light btn" value="修改">
             <input type="reset" class="waves-effect waves-light btn" value="清空">
            </form>
</center>
            
</body>
<%@ include file="foot.jsp"%>
</html>