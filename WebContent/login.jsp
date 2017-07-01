<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<title>登录</title>
</head>
<body>
<body>

	<div class="row">
		<form action="login.do" method="post">
			<div class="row">
				<div class="input-field col s4 offset-s4">
						帐号：<input placeholder="请输入帐号" name="userid" id="userid" type="text"class="validate">
						
				</div>
			</div>
			<div class="row">
				<div class="input-field col s4 offset-s4">
					
						密码：<input placeholder="请输入密码" name="pwd" id="pwd" type="password"
							class="validate">
				</div>
			</div>
			<center>
				<input class="waves-effect waves-light btn" type="submit" value="登陆">
				<input class="waves-effect waves-light btn" type="button"
					onclick="window.location.href='register.jsp'" value="注册">
		</form>
	</div>
</body>


</html>