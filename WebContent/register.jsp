<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form action="register.do" method="post">
		<center>帐号:<input type="text" name="userid"><br />
		<center>密码:<input type="password" name="pwd"><br />
		<center>昵称:<input type="text" name="username"><br />
		<center>QQ:<input type="text" name="QQ"><br />
		<center>TEL:<input type="text" name="TEL"><br />
		<center><input type="submit" value="注册"> 
		<a href="login.jsp"></a>
	</form>
</body>
</html>