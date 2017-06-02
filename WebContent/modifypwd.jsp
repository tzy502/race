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
<%  %> 
	<form action="modifypwd.do" method="post">
		<center>帐号:<%=user.getUserid() %>
		<center>旧密码:<input type="password" name="oldpwd"><br />
		<center>新密码:<input type="password" name="newpwd1"><br />
		<center>重复新密码:<input type="password" name="newpwd2"><br />			
		<center><input type="submit" value="修改"> <input type="reset" value="清空">
	</form>
</body>
</html>