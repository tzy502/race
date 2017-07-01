<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
 <div class="row">
	<form action="register.do" method="post">
	<div class="row">
			<div class="input-field col s4 offset-s4">	
				帐号:<input placeholder="请输入帐号" name="userid" id="userid" type="text"class="validate">
			</div>
			<div class="input-field col s4 offset-s4">	
				密码:<input placeholder="请输入帐号"  type="password" name="pwd" class="validate">
			</div>
			<div class="input-field col s4 offset-s4">
				昵称:<input placeholder="请输入昵称"  type="text" name="username" class="validate">
			</div>
			<div class="input-field col s4 offset-s4">
				QQ:<input placeholder="请输入QQ"  type="text" name="QQ" class="validate">
			</div>	
			<div class="input-field col s4 offset-s4">
				TEL:<input placeholder="请输入TEL"  type="text" name="TEL" class="validate">
			</div>	
		</div>		
		<center><input class="waves-effect waves-light btn" type="submit" value="注册"> <a  class="waves-effect waves-light btn" href="login.jsp">返回</a>
	</form>
 </div>
</body>
</html>