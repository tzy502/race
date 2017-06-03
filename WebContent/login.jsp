<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<body>
	<form action="login.do" method="post">
		<center>帐号:<input type="text" name="userid"><br />
		<center>密码:<input type="password" name="pwd"><br />
		<center><input type="submit" value="登陆"> <input type="button" onclick="window.location.href='register.jsp'" value="注册">
	</form>
	
</body>


</html>